package com.cave.prog.spring.test.autowiring;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author fatu
 */
@Component
public class RandomText {

    private static String[] texts = {
        "I'll be back.",
        "Get out!",
        "I want your clothes, boots and motorcycle."
    };

    public String getText() {
        Random random = new Random();

        return texts[random.nextInt(texts.length)];
    }

}
