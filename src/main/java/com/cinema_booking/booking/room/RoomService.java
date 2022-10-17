package com.cinema_booking.booking.room;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema_booking.booking.exception.RoomNotFindException;
import com.cinema_booking.booking.room.dto.RoomMapper;
import com.cinema_booking.booking.room.dto.model.RoomRequest;
import com.cinema_booking.booking.room.dto.model.RoomResponse;
import com.cinema_booking.booking.room.model.Room;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    @Autowired
    public RoomService(RoomMapper roomMapper, RoomRepository roomRepository) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
    }

    public RoomResponse getRoomById(UUID id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFindException(id));
        return roomMapper.mapRoomToRoomResponse(room);
    }

    public List<RoomResponse> getRoomResponseList() {
        List<Room> roomList = roomRepository.findAll();
        List<RoomResponse> roomResponseList = roomMapper.mapRoomListToRoomResponseList(roomList);
        return roomResponseList;
    }

    public RoomResponse createRoom(RoomRequest roomRequest) {
        Room newRoom = roomMapper.mapRoomRequestToRoom(roomRequest);
        return roomMapper.mapRoomToRoomResponse(roomRepository.save(newRoom));
    }

    public RoomResponse updateRoom(RoomRequest roomRequest, UUID id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFindException(id));
        Room newRoomData = roomMapper.mapRoomRequestToRoom(roomRequest);
        room.setRoomName(newRoomData.getRoomName());
        room.setRoomSeatCounter(newRoomData.getRoomSeatCounter());
        return roomMapper.mapRoomToRoomResponse(roomRepository.save(room));
    }

    public void deleteRoom(UUID id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFindException(id));
        roomRepository.delete(room);
    }
}
