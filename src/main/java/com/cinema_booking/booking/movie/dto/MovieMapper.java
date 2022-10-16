package com.cinema_booking.booking.movie.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cinema_booking.booking.movie.dto.model.MovieRequest;
import com.cinema_booking.booking.movie.dto.model.MovieResponse;
import com.cinema_booking.booking.movie.model.Movie;

@Mapper()
public interface MovieMapper {

    @Mapping(source = "title", target = "movieTitle")
    @Mapping(source = "duration", target = "movieDurationTime")
    Movie mapMovieRequestToMovie(MovieRequest movieRequest);

    MovieRequest mapMovieRequestToMovie(Movie movie);

    @Mapping(source = "movieTitle", target = "title")
    @Mapping(source = "movieDurationTime", target = "duration")
    MovieResponse mapMovieToMovieResponse(Movie movie);

    List<MovieResponse> mapMovieListToMovieResponse(Set<Movie> movies);

    Set<Movie> mapMovieRequestToMovieLis(List<MovieRequest> movieRequests);
}
