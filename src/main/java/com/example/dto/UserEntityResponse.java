package com.example.dto;


import com.example.model.Url;
import com.example.model.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class UserEntityResponse {
    @JsonIgnore
    private String countingOfVisit;
    private Integer id;
    private String numberOfVisit;
    private List<Url> uniqueVisitedUserPages = new ArrayList<>();

    public UserEntityResponse(UserEntity userEntity, String urlsRequest) {
        for (Url urlUser : userEntity.getUrls()
        ) {
            if (urlUser.getUrls().equals(urlsRequest)) {
                uniqueVisitedUserPages.add(urlUser);
            }
        }
        countingUrls(uniqueVisitedUserPages);
        this.id = userEntity.getId();
        this.numberOfVisit = countingOfVisit;
    }


    private void countingUrls(List<Url> list) {
        Map<Url, Integer> hm = new HashMap<>();
        for (Url i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        for (Map.Entry<Url, Integer> val : hm.entrySet()) {
            countingOfVisit = val.getKey() + " visited " + val.getValue() + " times";
        }
    }
}
