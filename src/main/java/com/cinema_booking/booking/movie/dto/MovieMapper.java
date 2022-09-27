package com.cinema_booking.booking.movie.dto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.cinema_booking.booking.movie.model.Movie;
import com.cinema_booking.booking.room.dto.RoomMapper;

@Mapper(uses = { RoomMapper.class }, componentModel = "spring")
public interface MovieMapper {
    Movie mapToMovie(Movie movieDTO);

    @InheritInverseConfiguration(name = "mapToMovie")
    MovieDTO mapMovieToMovieDTO(Movie movie);
}
