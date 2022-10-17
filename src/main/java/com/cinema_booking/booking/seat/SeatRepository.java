package com.cinema_booking.booking.seat;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema_booking.booking.seat.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, UUID> {

}
