package com.cave.prog.spring.test.autowiring;

import org.springframework.stereotype.Component;

/**
 * @author boaztu
 */
@Component
public interface LogWriter {

    public void write(String text);
}
