package com.cinema_booking.booking.room.dto.model;

import java.util.List;
import java.util.UUID;

import com.cinema_booking.booking.movie.dto.model.MovieResponse;
import com.cinema_booking.booking.seat.dto.model.SeatResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {
    private UUID id;
    private String name;
    private int seatsCounter;
    private List<MovieResponse> movies;
    private List<SeatResponse> seats;
}
