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
    private Integer uniqueUserVisit;
    private Integer totalNumberOfVisit;
    private List<String> regularUsers = new ArrayList<>();
    private Integer numberOfRegularUser;

    public UserEntityResponseForAnyPeriod(LocalDate localDate, List<UserEntity> userList) {

        for (UserEntity user : userList) {
            if (user.getUrls().iterator().next().getDate().equals(localDate)) {
                urlsList.addAll(user.getUrls());
            }

        }
        for (UserEntity user : userList) {
            if (user.getUrls().stream().distinct().count() >= 10) {
                regularUsers.add(user.getUsername());
            }
        }
        this.numberOfRegularUser = regularUsers.size();
        this.totalNumberOfVisit = urlsList.size();
        this.uniqueUserVisit = userList.size();

    }
}

