package com.olol.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */
@Component("car")
@Deprecated
public class Car {
    public void start() {
        System.out.println("Car starting");
    }
}
