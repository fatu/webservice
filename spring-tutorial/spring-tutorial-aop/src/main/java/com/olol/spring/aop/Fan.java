package com.olol.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */
@Component
public class Fan implements IFan {
    public void activate(int level) {
        System.out.println("Fan running at level " + level);
    }
}
