package com.cinema_booking.booking.room;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema_booking.booking.room.dto.RoomDTO;
import com.cinema_booking.booking.room.dto.RoomMapper;
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

    public RoomDTO getRoomDTOById(UUID id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
        RoomDTO roomDTO = roomMapper.mapRoomToRoomDTO(room);
        return roomDTO;
    }

    public List<RoomDTO> getRoomDTOList() {
        List<Room> roomList = roomRepository.findAll();
        List<RoomDTO> roomDTOList = roomMapper.mapRoomListToRoomDTOList(roomList);
        return roomDTOList;
    }

    public Room createRoom(RoomDTO roomDTO) {
        Room newRoom = roomMapper.mapToRoom(roomDTO);
        return roomRepository.save(newRoom);
    }

    public RoomDTO updateRoom(RoomDTO roomDTO, UUID id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
        Room newRoomData = roomMapper.mapToRoom(roomDTO);
        room.setRoomName(newRoomData.getRoomName());
        room.setRoomSeat(newRoomData.getRoomSeat());
        return roomMapper.mapRoomToRoomDTO(roomRepository.save(room));
    }

    public void deleteRoom(UUID id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
        roomRepository.delete(room);
    }
}
