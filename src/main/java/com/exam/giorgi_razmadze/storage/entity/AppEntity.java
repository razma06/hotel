package com.exam.giorgi_razmadze.storage.entity;

import com.exam.giorgi_razmadze.storage.enumerated.RecordState;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AppEntity {

    @CreationTimestamp
    protected LocalDateTime createdDate;

    @UpdateTimestamp
    protected LocalDateTime lastModifiedDate;

    @Enumerated(EnumType.STRING)
    protected RecordState recordState;

}
