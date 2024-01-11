package com.exam.giorgi_razmadze.aspects;

import com.exam.giorgi_razmadze.storage.entity.CodeExecutionTimeEntity;
import com.exam.giorgi_razmadze.storage.repository.CodeExecutionTimeRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimerAspect {

    private final CodeExecutionTimeRepository codeExecutionTimeRepository;

    @Around("@annotation(Loggable)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        CodeExecutionTimeEntity codeExecutionTimeEntity = new CodeExecutionTimeEntity();
        codeExecutionTimeEntity.setExecutionTime(executionTime);
        codeExecutionTimeEntity.setMethodName(joinPoint.getSignature().getName());
        codeExecutionTimeEntity.setClassName(joinPoint.getSignature().getDeclaringTypeName());
        codeExecutionTimeEntity.setExecutionDate(LocalDateTime.now());

        codeExecutionTimeRepository.save(codeExecutionTimeEntity);

        return proceed;
    }

}
