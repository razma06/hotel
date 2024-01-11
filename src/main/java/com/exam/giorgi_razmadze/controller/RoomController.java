package com.exam.giorgi_razmadze.controller;

import com.exam.giorgi_razmadze.service.RoomService;
import com.exam.giorgi_razmadze.storage.dto.RoomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/room")
public class RoomController {

    private  final RoomService roomService;


    @PostMapping
    public void addRoom(@RequestBody RoomDTO roomDTO) {
        roomService.addRoom(roomDTO);
    }

}
