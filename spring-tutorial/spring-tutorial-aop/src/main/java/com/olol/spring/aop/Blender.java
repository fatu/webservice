package com.olol.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */
@Component
public class Blender implements IBlender {
    public void blend() {
        System.out.println("Blending ...");
    }
}
