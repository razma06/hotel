package com.exam.giorgi_razmadze.controller;

import com.exam.giorgi_razmadze.service.HotelService;
import com.exam.giorgi_razmadze.storage.dto.HotelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotel")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public List<HotelDTO> getHotels() {
        return hotelService.getHotels();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addHotel(@RequestBody HotelDTO hotelDTO) {
        hotelService.addHotel(hotelDTO);
    }



}
