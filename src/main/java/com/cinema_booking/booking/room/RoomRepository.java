package com.cinema_booking.booking.room;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema_booking.booking.room.model.Room;

public interface RoomRepository extends JpaRepository<Room, UUID> {
}
