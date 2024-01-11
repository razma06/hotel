package com.exam.giorgi_razmadze.storage.dto.mapper;

import com.exam.giorgi_razmadze.storage.dto.HotelDTO;
import com.exam.giorgi_razmadze.storage.entity.HotelEntity;

public class HotelMapper {

    public static HotelDTO toDTO(HotelEntity hotelEntity) {
        return HotelDTO.builder()
                .id(hotelEntity.getId())
                .name(hotelEntity.getName())
                .address(hotelEntity.getAddress())
                .build();
    }

}
