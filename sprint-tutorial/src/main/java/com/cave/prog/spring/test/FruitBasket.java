package com.cave.prog.spring.test;

import java.util.List;

/**
 * @author boaztu
 */
public class FruitBasket {
    private String name;
    private List<String> fruits;

    public FruitBasket(final String name, final List<String> fruits) {
        this.name = name;
        this.fruits = fruits;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" contains:\n");

        for (String fruit : fruits) {
            sb.append(fruit);
            sb.append("\n");
        }

        return sb.toString();
    }
}
