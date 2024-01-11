package com.exam.giorgi_razmadze.service;

import com.exam.giorgi_razmadze.storage.dto.RoomDTO;
import com.exam.giorgi_razmadze.storage.dto.mapper.RoomMapper;
import com.exam.giorgi_razmadze.storage.entity.HotelEntity;
import com.exam.giorgi_razmadze.storage.entity.RoomEntity;
import com.exam.giorgi_razmadze.storage.enumerated.RoomState;
import com.exam.giorgi_razmadze.storage.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;


    public void addRoom(RoomDTO roomDTO) {
        RoomEntity roomEntity = RoomEntity.builder()
                .price(roomDTO.getPrice())
                .code(roomDTO.getCode())
                .hotel(HotelEntity.builder().id(roomDTO.getHotel().getId()).build())
                .build();

        roomRepository.save(roomEntity);
    }

    public List<RoomDTO> getFreeRooms(LocalDateTime startTime, LocalDateTime endTime) {
        return roomRepository.getFreeRooms(startTime, endTime)
                .stream().map(RoomMapper::toDTO).toList();
    }


}
