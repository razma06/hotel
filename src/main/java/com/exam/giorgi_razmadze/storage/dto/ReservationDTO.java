package com.exam.giorgi_razmadze.storage.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Long id;

    private String code;

    private String name;

    private String surname;

    private RoomDTO room;

    private LocalDateTime reservedFrom;

    private LocalDateTime reservedTo;

}
