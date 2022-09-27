package com.cinema_booking.booking.movie.dto;

import java.util.Set;
import java.util.UUID;

import com.cinema_booking.booking.room.model.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private UUID id;
    private String title;
    private String startDate;
    private int duration;
    private Set<Room> rooms;
}
