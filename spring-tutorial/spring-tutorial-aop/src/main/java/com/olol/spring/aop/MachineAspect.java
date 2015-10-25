package com.olol.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */
@Component
@Aspect
public class MachineAspect {

    @DeclareParents(value = "com.olol.spring.aop.*", defaultImpl = com.olol.spring.aop.Machine.class)
    private IMachine machine;

    @Around("within(com.olol.spring.aop.*)")
    public void runMachine(ProceedingJoinPoint joinPoint) {
        System.out.println("Running ...");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("... completed. ");

    }
}
