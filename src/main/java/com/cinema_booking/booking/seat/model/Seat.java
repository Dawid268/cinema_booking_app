package com.cinema_booking.booking.seat.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cinema_booking.booking.room.model.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room_seat")
public class Seat {

    @Id
    @GeneratedValue()
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "seatState")
    @Enumerated(EnumType.STRING)
    private SeatState seatState;

    @Column(name = "seatRow")
    private String seatRow;

    @Column(name = "seatColumn")
    private String seatColumn;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
}
