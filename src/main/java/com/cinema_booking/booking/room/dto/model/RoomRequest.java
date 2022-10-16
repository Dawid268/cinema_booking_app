package com.cinema_booking.booking.room.dto.model;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import com.cinema_booking.booking.movie.dto.model.MovieRequest;
import com.cinema_booking.booking.seat.dto.model.SeatRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    @JsonProperty("id")
    private UUID id;
    @NotBlank(message = "Room name cannot be empty")
    private String name;
    @Max(message = "Seats counter must be less than 360", value = 360)
    @Min(message = "Seats counter must be greater than 50", value = 50)
    private int seatsCounter;
    private List<MovieRequest> movies;
    private List<SeatRequest> seats;
}
