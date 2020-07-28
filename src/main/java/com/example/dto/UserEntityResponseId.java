package com.example.dto;

import com.example.model.Url;
import com.example.model.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class UserEntityResponseId {

    @JsonIgnore
    private List<String> uniqueVisited = new ArrayList<>();
    @JsonIgnore
    private List<Url> uniqueVisitedUserPages = new ArrayList<>();
    private Integer id;

    private List<String> userVisited;

    public UserEntityResponseId(UserEntity userEntity) {
        uniqueVisitedUserPages.addAll(
                userEntity
                        .getUrls());
        countingUrls(uniqueVisitedUserPages);
        this.id = userEntity.getId();
        this.userVisited = new ArrayList<>(uniqueVisited);
    }

    private void countingUrls(List<Url> list) {
        Map<Url, Integer> hm = new HashMap<>();
        for (Url i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        for (Map.Entry<Url, Integer> val : hm.entrySet()) {
            uniqueVisited.add(val.getKey() + " visited " + val.getValue() + " times");
            list.stream().distinct().collect(Collectors.toList());

        }
    }
}

