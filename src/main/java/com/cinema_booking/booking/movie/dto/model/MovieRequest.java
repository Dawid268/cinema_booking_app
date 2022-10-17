package com.cinema_booking.booking.movie.dto.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    @NotBlank(message = "Movie title cannot be empty")
    private String title;
    @Min(message = "Movie duration must be greater than 0", value = 1)
    private int duration;
}
