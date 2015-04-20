package com.blogspot.jpdevelopment.mongodb.core.domain;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Person {

    @Id
    private final UUID id;
    private final String name;
    private final String title;
    private final Department department;

    public Person(String name, String title, Department department) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.title = title;
        this.department = department;
    }

    public UUID getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "department=" + department +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
