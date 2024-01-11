package com.exam.giorgi_razmadze.service;

import com.exam.giorgi_razmadze.storage.dto.ReservationDTO;
import com.exam.giorgi_razmadze.storage.dto.mapper.ReservationMapper;
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

}
