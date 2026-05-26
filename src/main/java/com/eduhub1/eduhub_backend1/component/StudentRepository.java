package com.eduhub1.eduhub_backend1.component;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Jane", "Smith"));
        students.add(new Student(3, "Mike", "Johnson"));
        return students;
    }
    
    public Student getStudentById(int id) {
        List<Student> students = getAllStudents();
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
