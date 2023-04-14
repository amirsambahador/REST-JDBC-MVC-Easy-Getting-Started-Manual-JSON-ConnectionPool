package org.j2os.project.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private long id;
    private String name;
    private String family;

    public Person() {
    }

    private long salary;

    public Person(String name, String family, long salary) {
        this.name = name;
        this.family = family;
        this.salary = salary;
    }

    public Person(long id, String name, String family, long salary) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public long getSalary() {
        return salary;
    }

    public Person setSalary(long salary) {
        this.salary = salary;
        return this;
    }
}
