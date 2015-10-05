package com.cave.prog.spring.test;

import com.cave.prog.spring.test.autowiring.Logger;
import com.cave.prog.spring.test.autowiring.Robot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Robot robot = (Robot) context.getBean("robot");

        robot.speak();

        ((ClassPathXmlApplicationContext) context).close();
    }

}
