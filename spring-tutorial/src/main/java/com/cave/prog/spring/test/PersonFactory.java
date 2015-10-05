package com.cave.prog.spring.test;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * @author boaztu
 */
public class PersonFactory {
    public static Person createPerson(int id, String name) {
        System.out.println("Using factory to create person.");
        return new Person(id, name);
    }
}
