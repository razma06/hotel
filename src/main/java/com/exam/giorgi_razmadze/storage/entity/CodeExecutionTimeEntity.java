package com.exam.giorgi_razmadze.storage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "code_execution_measurements")
public class CodeExecutionTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;

    private String methodName;

    @Column(name = "execution_time_ms")
    private Long executionTime;

    private LocalDateTime executionDate;

}
