package ru.gb.hw2;

import lombok.Data;

@Data
public class Student {
    private static long idCounter= 1L;
    private String name;
    private long id;
    private Group group;

    public Student(Group group, String name) {
        this.group = group;
        this.name=name;
        this.id = idCounter++;
    }

}
