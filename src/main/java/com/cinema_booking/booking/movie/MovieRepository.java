package com.cinema_booking.booking.movie;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema_booking.booking.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, UUID> {

}
