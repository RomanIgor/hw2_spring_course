package ru.gb.hw2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static ru.gb.hw2.Group.*;

@Component
public class StudentRepository {
    private final List<Student>allStudents;

    public StudentRepository(List<Student> all) {
        this.allStudents = new ArrayList<>();
        allStudents.add(new Student(MARKETING, "Igor"));
        allStudents.add(new Student(MARKETING, "John"));
        allStudents.add(new Student(MARKETING, "Maria"));
        allStudents.add(new Student(MANAGEMENT, "Tom"));
        allStudents.add(new Student(MANAGEMENT, "Tony"));
        allStudents.add(new Student(MANAGEMENT, "Sarah"));
        allStudents.add(new Student(BUSINESS, "Sergei"));
        allStudents.add(new Student(BUSINESS, "Nicole"));
        allStudents.add(new Student(ADMINISTRATION, "Christina"));
        allStudents.add(new Student(ADMINISTRATION, "David"));
    }


    public List<Student> getAllStudents() {
        return List.copyOf(allStudents);
    }

    public Student getById(long id){
        return allStudents.stream()
                .filter(it -> Objects.equals(it.getId(),id))
                .findFirst()
                .orElse(null);
    }

    public Student getByName(String name){
        return allStudents.stream()
                .filter(it -> Objects.equals(it.getName(),name))
                .findFirst()
                .orElse(null);
    }

    public List<Student>getByGroup(Group group){
        return allStudents
                .stream()
                .filter(student -> student.getGroup()==group)
                .collect(Collectors.toList());
    }

    public List<Student> addStudent(Student student){
      allStudents.add(student);
      return allStudents;
    }


    public List<Student> deleteById(long id){
        allStudents.removeIf(student -> student.getId()==id);
        return allStudents;
    }

}
