package com.exam.giorgi_razmadze.storage.dto.mapper;

import com.exam.giorgi_razmadze.storage.dto.ReservationDTO;
import com.exam.giorgi_razmadze.storage.entity.ReservationEntity;

public class ReservationMapper {

    public static ReservationDTO toDTO(ReservationEntity reservationEntity) {
        return ReservationDTO.builder()
                .id(reservationEntity.getId())
                .name(reservationEntity.getName())
                .surname(reservationEntity.getSurname())
                .room(RoomMapper.toDTO(reservationEntity.getRoom()))
                .reservedFrom(reservationEntity.getReservedFrom())
                .reservedTo(reservationEntity.getReservedTo())
                .build();
    }

}
