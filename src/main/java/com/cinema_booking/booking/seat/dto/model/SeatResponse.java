package com.cinema_booking.booking.seat.dto.model;

import java.util.UUID;

import com.cinema_booking.booking.seat.model.SeatState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatResponse {
    private UUID id;
    private SeatState state;
    private String row;
    private String column;
}
