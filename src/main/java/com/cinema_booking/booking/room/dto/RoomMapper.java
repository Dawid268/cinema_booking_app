package com.cinema_booking.booking.room.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cinema_booking.booking.movie.dto.MovieMapper;
import com.cinema_booking.booking.room.dto.model.RoomRequest;
import com.cinema_booking.booking.room.dto.model.RoomResponse;
import com.cinema_booking.booking.room.model.Room;
import com.cinema_booking.booking.seat.dto.SeatMapper;

@Mapper(uses = { MovieMapper.class, SeatMapper.class })
public interface RoomMapper {

    @Mapping(source = "name", target = "roomName")
    @Mapping(source = "seatsCounter", target = "roomSeatCounter")
    Room mapRoomRequestToRoom(RoomRequest roomRequest);

    RoomRequest mapRoomToRoomRequest(Room room);

    @Mapping(source = "roomName", target = "name")
    @Mapping(source = "roomSeatCounter", target = "seatsCounter")
    RoomResponse mapRoomToRoomResponse(Room room);

    List<RoomRequest> mapRoomListToRoomRequestList(List<Room> roomList);

    List<RoomResponse> mapRoomListToRoomResponseList(List<Room> roomList);
}
