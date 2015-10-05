package com.cave.prog.spring.test.autowiring;

/**
 * @author boaztu
 */
public class ConsoleWriter implements LogWriter{

    public ConsoleWriter() {
    }

    public void write(String text) {
        System.out.println(text);
    }

}
