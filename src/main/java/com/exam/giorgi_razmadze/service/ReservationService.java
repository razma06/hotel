package com.exam.giorgi_razmadze.service;

import com.exam.giorgi_razmadze.storage.dto.ReservationDTO;
import com.exam.giorgi_razmadze.storage.dto.mapper.ReservationMapper;
import com.exam.giorgi_razmadze.storage.entity.ReservationEntity;
import com.exam.giorgi_razmadze.storage.entity.RoomEntity;
import com.exam.giorgi_razmadze.storage.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<ReservationDTO> getReservations() {
        return reservationRepository.findAll()
                .stream().map(ReservationMapper::toDTO).toList();
    }

    public void addReservation(ReservationDTO reservationDTO) {
        ReservationEntity reservationEntity = ReservationEntity.builder()
                .room(RoomEntity.builder().id(reservationDTO.getRoom().getId()).build())
                .reservedFrom(reservationDTO.getReservedFrom())
                .reservedTo(reservationDTO.getReservedTo())
                .name(reservationDTO.getName())
                .surname(reservationDTO.getSurname())
                .build();

        reservationRepository.save(reservationEntity);
    }

}
