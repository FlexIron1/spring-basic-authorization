package com.example.dto;


import com.example.model.Url;
import com.example.model.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserEntityResponseForAnyPeriod {

    @JsonIgnore
    private List<Url> urlsList = new ArrayList<>();
    private Long uniqueUserVisit;
    private Integer totalNumberOfVisit;
    private List<String> regularUsers = new ArrayList<>();
    private Integer numberOfRegularUser;
    private List<String>uniqueUserList = new ArrayList<>();


    public UserEntityResponseForAnyPeriod(LocalDate localDate, List<UserEntity> userList) {

        for (UserEntity user : userList) {
            if (user.getUrls().iterator().hasNext()) {
                if (user.getUrls().iterator().next().getDate().equals(localDate)) {
                    urlsList.addAll(user.getUrls());
                    uniqueUserList.add(user.getUsername());
                }
            }

        }
        for (UserEntity user : userList) {
            if (user.getUrls().stream().distinct().count() >= 10) {
                regularUsers.add(user.getUsername());
            }
        }
        this.numberOfRegularUser = regularUsers.size();
        this.totalNumberOfVisit = urlsList.size();
        this.uniqueUserVisit = uniqueUserList.stream().distinct().count();

    }
}

