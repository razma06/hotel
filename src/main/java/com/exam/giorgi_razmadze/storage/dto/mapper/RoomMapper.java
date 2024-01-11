package com.exam.giorgi_razmadze.storage.dto.mapper;

import com.exam.giorgi_razmadze.storage.dto.RoomDTO;
import com.exam.giorgi_razmadze.storage.entity.RoomEntity;

public class RoomMapper {

    public static RoomDTO toDTO(RoomEntity roomEntity) {
        return RoomDTO.builder()
                .id(roomEntity.getId())
                .code(roomEntity.getCode())
                .price(roomEntity.getPrice())
                .hotel(HotelMapper.toDTO(roomEntity.getHotel()))
                .build();
    }

}
