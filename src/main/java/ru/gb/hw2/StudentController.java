package ru.gb.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/allStudents")
    public List<Student> allStudents() {
        return studentRepository.getAllStudents();
    }

    @GetMapping("/find/{id}")

    public Student studentById(@PathVariable long id) {
        return studentRepository.getById(id);
    }


    @GetMapping("/student/{name}")
    public Student studentByName(@RequestParam String name) {
        return studentRepository.getByName(name);
    }

    @GetMapping("/group{name}")
    public List<Student> studentByGroup(@RequestParam String name) {
        Group gr = Group.valueOf(name);
        return studentRepository.getByGroup(gr);
    }

    @PostMapping("/add")
    public List<Student> addStudent(@RequestBody Student student) {
        return studentRepository.addStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public List<Student> delete(@PathVariable long id) {
      return   studentRepository.deleteById(id);
    }

}
