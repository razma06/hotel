package com.exam.giorgi_razmadze.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDetailsResponse {

    @JsonProperty("HotelName")
    private String name;

    @JsonProperty("RentRoom")
    private int rentRooms;

    @JsonProperty("TotalAmount")
    private int totalAmount;

}
