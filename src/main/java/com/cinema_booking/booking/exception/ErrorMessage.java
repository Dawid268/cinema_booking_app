package com.cinema_booking.booking.exception;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private List<String> messages;

    public ErrorMessage(int statusCode, Date timestamp, String message) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
    }

    public ErrorMessage(int statusCode, Date timestamp, List<String> messages) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.messages = messages;
    }
}