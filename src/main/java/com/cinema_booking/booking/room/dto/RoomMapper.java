package com.cinema_booking.booking.room.dto;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cinema_booking.booking.movie.dto.MovieMapper;
import com.cinema_booking.booking.room.model.Room;

@Mapper(uses = { MovieMapper.class }, componentModel = "spring")
public interface RoomMapper {

    @Mapping(source = "name", target = "roomName")
    Room mapToRoom(RoomDTO roomDTO);

    @InheritInverseConfiguration(name = "mapToRoom")
    RoomDTO mapRoomToRoomDTO(Room room);

    List<RoomDTO> mapRoomListToRoomDTOList(List<Room> roomList);

}
