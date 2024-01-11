package com.exam.giorgi_razmadze.controller;

import com.exam.giorgi_razmadze.service.ReservationService;
import com.exam.giorgi_razmadze.storage.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public List<ReservationDTO> getReservations() {
        return reservationService.getReservations();
    }

    @PostMapping
    public void addReservation(ReservationDTO reservationDTO) {
        reservationService.addReservation(reservationDTO);
    }


}
