package com.exam.giorgi_razmadze.service;

import com.exam.giorgi_razmadze.aspects.Loggable;
import com.exam.giorgi_razmadze.storage.dto.HotelDTO;
import com.exam.giorgi_razmadze.storage.dto.mapper.HotelMapper;
import com.exam.giorgi_razmadze.storage.entity.HotelEntity;
import com.exam.giorgi_razmadze.storage.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    @Loggable
    public void addHotel(HotelDTO hotelDTO) {
        HotelEntity hotelEntity = HotelEntity.builder()
                .name(hotelDTO.getName())
                .address(hotelDTO.getAddress())
                .build();

        hotelRepository.save(hotelEntity);
    }

    public List<HotelDTO> getHotels() {
        return hotelRepository.findAll()
                .stream().map(HotelMapper::toDTO).toList();
    }


}
