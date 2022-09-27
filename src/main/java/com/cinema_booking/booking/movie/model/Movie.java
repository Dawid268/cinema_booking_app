package com.cinema_booking.booking.movie.model;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cinema_booking.booking.room.model.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue()
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "movieTitle")
    private String movieTitle;

    @Column(name = "movieStartDate")
    private LocalDate movieStartDate;

    @Column(name = "movieDurationTime")
    private int movieDurationTime;

    @ManyToMany(mappedBy = "movies")
    private Set<Room> rooms;
}
