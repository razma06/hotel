package com.exam.giorgi_razmadze.storage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservations")
public class ReservationEntity extends AppEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private RoomEntity room;

    private String name;

    private String surname;

    private LocalDateTime reservedFrom;

    private LocalDateTime reservedTo;

}
