package com.exam.giorgi_razmadze.storage.repository;

import com.exam.giorgi_razmadze.storage.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {


    @Query("SELECT r FROM RoomEntity r WHERE (" +
            "r not in (" +
                "SELECT re FROM ReservationEntity re WHERE re.reservedFrom <= :endTime AND re.reservedTo >= :startTime" +
                ")" +
            ")")
    List<RoomEntity> getFreeRooms(LocalDateTime startTime, LocalDateTime endTime);


}
