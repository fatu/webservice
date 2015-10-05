package com.cave.prog.spring.test.autowiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */
@Component("fileWriter")
public class FileWriter implements LogWriter{

    public void write(String text) {
        System.out.println("Write to file: " + text);
    }

}
