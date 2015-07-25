package com.blogspot.jpdevelopment.spring.validation;

/**
 * Created by jp on 23-07-2015.
 */
public class Person {

    private final String firstname;
    private final String lastname;
    private final int age;

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFullName() {
        return this.firstname + " " + this.lastname;
    }

    public int getAge() {
        return this.age;
    }
}
