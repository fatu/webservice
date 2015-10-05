package com.cave.prog.spring.test.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * @author fatu
 */
@Component
public class Robot {

    private String id = "Default robot";
    private String speech = "hello";

    public void speak() {
        System.out.println(id + ": " + speech);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }
}
