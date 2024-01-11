package com.exam.giorgi_razmadze.storage.dto;

import com.exam.giorgi_razmadze.storage.enumerated.RoomState;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private Long id;

    private String code;

    private int price;

    private HotelDTO hotel;


}
