package com.cinema_booking.booking.room.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cinema_booking.booking.movie.model.Movie;
import com.cinema_booking.booking.seat.model.Seat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue()
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "room_name", nullable = false)
    private String roomName;

    @Column(name = "room_seat_counter", nullable = false)
    private int roomSeatCounter;

    @ManyToMany()
    @JoinTable(name = "room_movie", joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;

    @ManyToMany()
    @JoinTable(name = "room_seat", joinColumns = @JoinColumn(name = "room_id"), inverseJoinColumns = @JoinColumn(name = "seat_id"))
    private Set<Seat> seats;
}
