package com.exam.giorgi_razmadze.storage.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {

    private long id;

    private String name;

    private String address;

}
