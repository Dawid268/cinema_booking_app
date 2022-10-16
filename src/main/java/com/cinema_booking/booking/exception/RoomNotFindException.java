package com.cinema_booking.booking.exception;

public class RoomNotFindException extends RuntimeException {

    public RoomNotFindException() {
        super("Room don`t exist");
    }
}