package com.cave.prog.spring.test.autowiring;

import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */
@Component
public class ConsoleWriter implements LogWriter{

    public ConsoleWriter() {
    }

    public void write(String text) {
        System.out.println(text);
    }

}
