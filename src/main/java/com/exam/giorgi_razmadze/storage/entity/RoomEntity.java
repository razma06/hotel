package com.exam.giorgi_razmadze.storage.entity;

import com.exam.giorgi_razmadze.storage.enumerated.RoomState;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class RoomEntity extends AppEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private int price;

    @ManyToOne
    private HotelEntity hotel;

}
