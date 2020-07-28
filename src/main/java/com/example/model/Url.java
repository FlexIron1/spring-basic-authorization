package com.example.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Embeddable;
import java.sql.Timestamp;
import java.time.LocalDate;

@Embeddable
@Data
public class Url {
    private String urls;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate date;

}
