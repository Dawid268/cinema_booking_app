package com.cinema_booking.booking.seat.dto;

import java.util.UUID;

import com.cinema_booking.booking.room.model.Room;
import com.cinema_booking.booking.seat.model.SeatState;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {
    private UUID id;
    private SeatState state;
    private String row;
    private String column;
    private Room rooms;
}
