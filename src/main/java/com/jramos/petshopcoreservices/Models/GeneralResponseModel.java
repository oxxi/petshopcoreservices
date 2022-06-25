package com.jramos.petshopcoreservices.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@JsonPropertyOrder({"id","timestamp","status","error","message"})
public class GeneralResponseModel {

    private String Id;
    @JsonProperty("timestamp")
    private LocalDateTime TimeStamp;
    private String Status;
    private String Error;
    private String Message;
    private String Path;
}
