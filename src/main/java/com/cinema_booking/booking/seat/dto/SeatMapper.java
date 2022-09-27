package com.cinema_booking.booking.seat.dto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cinema_booking.booking.room.dto.RoomMapper;
import com.cinema_booking.booking.seat.model.Seat;

@Mapper(uses = { RoomMapper.class }, componentModel = "spring")
public interface SeatMapper {

    @Mapping(source = "state", target = "seatState")
    @Mapping(source = "row", target = "seatRow")
    @Mapping(source = "column", target = "seatColumn")
    Seat mapToSeat(SeatDTO seatDTO);

    @InheritInverseConfiguration(name = "mapToSeat")
    SeatDTO mapToSeatDTO(Seat seat);
}
