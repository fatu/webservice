package com.olol.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */

//@Aspect
@Component
public class Logger {

    @Pointcut("args(exposure, aperture)")
    public void somePointcut(int exposure, double aperture) {

    }

    @Pointcut("target(com.olol.spring.aop.Camera)")
    public void targetCamera() {

    }

    @Before("targetCamera() && somePointcut(exposure, aperture)")
    public void somePointcutDemo(JoinPoint jp, int exposure, double aperture) {
        System.out.println("*********** somePointcutDemo ***********");

        System.out.printf("exposure %d, aperture %.2f\n", exposure, aperture);
    }

    @After("within(com.olol.spring.aop.*) && !@annotation(Deprecated)")
    public void someAfterAdvice() {
        System.out.println("After advice running !!!!!!!!!!");
    }
}

