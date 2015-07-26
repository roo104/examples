package com.blogspot.jpdevelopment.spring.validation;

public class Person {

    private String firstname;
    private String lastname;
    private int age;

    public Person() {

    }

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

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }
}
