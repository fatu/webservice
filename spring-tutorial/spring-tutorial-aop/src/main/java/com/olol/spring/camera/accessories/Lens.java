package com.olol.spring.camera.accessories;

import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */
@Component
public class Lens {
    public void zoom(int factor) {
        System.out.println("Zooming lens " + factor);
    }
}
