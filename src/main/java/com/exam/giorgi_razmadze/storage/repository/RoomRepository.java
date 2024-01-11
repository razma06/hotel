package com.exam.giorgi_razmadze.storage.repository;

import com.exam.giorgi_razmadze.storage.entity.RoomEntity;
import com.exam.giorgi_razmadze.storage.enumerated.RoomState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    @Query("select r from RoomEntity r where r.state = ?1")
    List<RoomEntity> getRoomEntitiesByState(RoomState state);

}
