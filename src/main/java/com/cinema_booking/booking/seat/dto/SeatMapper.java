package com.cinema_booking.booking.seat.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cinema_booking.booking.seat.dto.model.SeatRequest;
import com.cinema_booking.booking.seat.dto.model.SeatResponse;
import com.cinema_booking.booking.seat.model.Seat;

@Mapper()
public interface SeatMapper {

    @Mapping(source = "state", target = "seatState")
    @Mapping(source = "row", target = "seatRow")
    @Mapping(source = "column", target = "seatColumn")
    Seat mapSeatRequestToSeat(SeatRequest seatRequest);

    SeatResponse mapSeatToSeatResponse(Seat seat);

    List<SeatResponse> mapSeatListToSeatResponseList(List<Seat> seats);

}
