package com.olol.spring.aop;

/**
 * @author boaztu
 */
public interface ICamera {

    public void snap();
    public void snap(int exposure);
    public String snap(String name);
    public void snapNighttime();

    public abstract void snapCar(Car car);

    void snap(double v);

    void snap(int i, double v);
}