package com.cave.prog.spring.test.autowiring;

/**
 * @author boaztu
 */
public class FileWriter implements LogWriter{

    public void write(String text) {
        System.out.println("Write to file: " + text);
    }

}
