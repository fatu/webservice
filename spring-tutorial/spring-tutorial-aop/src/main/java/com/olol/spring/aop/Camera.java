package com.olol.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */
@Component("camera")
public class Camera implements ICamera{


    public void snap() {
        System.out.println("SNAP!");
    }
    @Deprecated
    public void snap(int exposure) {
        System.out.println("SNAP! " + exposure);
    }

    public String snap(String name) {
        System.out.println("SNAP!Name! " + name);

        return name;
    }

    public void snapNighttime() {
        System.out.println("SNAP! Night mode.");
    }

    public void snapCar(Car car) {
        System.out.println("Snapping car!");
    }

    public void snap(final double v) {
        System.out.println("SNAP with aperture " + v);
    }

    public void snap(final int i, final double v) {
        System.out.println("SNAP with exposure " + i + " aperture " + v);
    }
}
