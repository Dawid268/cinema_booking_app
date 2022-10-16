package com.cinema_booking.booking.room;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinema_booking.booking.room.dto.model.RoomRequest;
import com.cinema_booking.booking.room.dto.model.RoomResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/list")
    public ResponseEntity<List<RoomResponse>> getRoomList() {
        List<RoomResponse> roomDTOList = roomService.getRoomResponseList();
        return new ResponseEntity<>(roomDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(roomService.getRoomById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RoomResponse> addRoom(@Valid @RequestBody RoomRequest roomRequest) {
        return new ResponseEntity<>(roomService.createRoom(roomRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> updateRoom(@Valid @RequestBody RoomRequest roomRequest,
            @PathVariable("id") UUID id) {
        return new ResponseEntity<>(roomService.updateRoom(roomRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") UUID id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
