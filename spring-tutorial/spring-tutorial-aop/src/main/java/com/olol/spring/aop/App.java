package com.olol.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author boaztu
 */
public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Camera camera = (Camera) context.getBean("camera");

        camera.snap();

        context.close();
    }




}
