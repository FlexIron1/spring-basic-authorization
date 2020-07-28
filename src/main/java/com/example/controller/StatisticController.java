package com.example.controller;


import com.example.dto.UrlsRequest;
import com.example.dto.UserEntityResponse;
import com.example.dto.UserEntityResponseForAnyPeriod;
import com.example.dto.UserEntityResponseId;
import com.example.model.UserEntity;
import com.example.repository.UserRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StatisticController {

    private UserRepository userRepository;

    public StatisticController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @PostMapping("/infoByAnyPeriod/{date}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserEntityResponseForAnyPeriod entryTwo(@PathVariable(value = "date")
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {

        List<UserEntity> byLocalDate = userRepository.findByLocalDate(date);
        if (byLocalDate == null) {
            throw new NullPointerException("Date found");
        }
        return new UserEntityResponseForAnyPeriod(date, byLocalDate);
    }


    @GetMapping(value = "/getInfoById/{id}")
    public UserEntityResponseId getSiteVisitEvent(@PathVariable(value = "id") Integer id) {
        UserEntity byId = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User not found by id " + id)

        );

        return new UserEntityResponseId(byId);

    }


    @PostMapping(value = "/infoByUrlsAndId")
    public UserEntityResponse siteVisitEvent(@RequestBody UrlsRequest urlsRequest) {
        UserEntity byUrlsAndId = userRepository.findByUrlsAndUserId(urlsRequest.getUrls(), urlsRequest.getUser_entity_id());
        if (byUrlsAndId == null) {
            throw new NullPointerException("Url or Id not found");
        }

        return new UserEntityResponse(byUrlsAndId, urlsRequest.getUrls());
    }

}
