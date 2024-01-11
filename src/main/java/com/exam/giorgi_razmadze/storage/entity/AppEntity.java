package com.exam.giorgi_razmadze.storage.entity;

import com.exam.giorgi_razmadze.storage.enumerated.RecordState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class AppEntity {

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

    @Enumerated(EnumType.STRING)
    private RecordState recordState;

}
