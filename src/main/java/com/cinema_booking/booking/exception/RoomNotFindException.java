package com.cinema_booking.booking.exception;

import java.util.UUID;

public class RoomNotFindException extends RuntimeException {

    public RoomNotFindException(UUID id) {
        super(String.format("Room with that id %s! don`t exist", id));
    }
}