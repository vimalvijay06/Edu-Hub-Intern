package com.eduhub1.eduhub_backend1.controller;

import com.eduhub1.eduhub_backend1.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Rama", "KS");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "John", "Doe"));
        studentList.add(new Student(2, "Jane", "Smith"));
        studentList.add(new Student(3, "Mike", "Johnson"));
        studentList.add(new Student(4, "Sarah", "Williams"));
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}
