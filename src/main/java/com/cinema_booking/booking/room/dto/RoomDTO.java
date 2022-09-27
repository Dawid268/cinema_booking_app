package com.cinema_booking.booking.room.dto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.cinema_booking.booking.movie.model.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private UUID id;
    private String name;
    private List<Movie> movies;
    private Set<Movie> seats;
}
