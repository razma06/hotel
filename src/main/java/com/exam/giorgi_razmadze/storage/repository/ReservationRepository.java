package com.exam.giorgi_razmadze.storage.repository;

import com.exam.giorgi_razmadze.storage.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
