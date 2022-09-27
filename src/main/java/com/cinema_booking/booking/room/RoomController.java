package com.cinema_booking.booking.room;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema_booking.booking.room.dto.RoomDTO;
import com.cinema_booking.booking.room.model.Room;

@Controller
@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<RoomDTO>> getRoomList() {
        try {
            List<RoomDTO> roomDTOList = roomService.getRoomDTOList();
            return new ResponseEntity<>(roomDTOList, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomDTOById(@PathVariable("id") UUID id) {
        try {
            RoomDTO roomDTO = roomService.getRoomDTOById(id);
            return new ResponseEntity<>(roomDTO, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody RoomDTO roomDTO) {
        try {
            Room createdRoom = roomService.createRoom(roomDTO);
            return new ResponseEntity<>(createdRoom, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO roomDTO, @PathVariable("id") UUID id) {
        try {
            RoomDTO updatedRoom = roomService.updateRoom(roomDTO, id);
            return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") UUID id) {
        try {
            roomService.deleteRoom(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
