package com.example.demo.controller;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Student save(@RequestBody Student s) {
        return repo.save(s);
    }

    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }
}
