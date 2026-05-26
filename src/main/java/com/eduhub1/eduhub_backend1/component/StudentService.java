package com.eduhub1.eduhub_backend1.component;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StudentService {
    
    private final StudentRepository studentRepository;
    private final LoggerComponent logger;
    
    public StudentService(StudentRepository studentRepository, LoggerComponent logger) {
        this.studentRepository = studentRepository;
        this.logger = logger;
    }
    
    public List<Student> getAllStudents() {
        this.logger.logInfo("Fetching all students...");
        List<Student> students = this.studentRepository.getAllStudents();
        this.logger.logInfo("Found " + students.size() + " students");
        return students;
    }
    
    public Student getStudentById(int id) {
        this.logger.logInfo("Fetching student with ID: " + id);
        Student student = this.studentRepository.getStudentById(id);
        if (student != null) {
            this.logger.logInfo("Student found: " + student.getFirstName() + " " + student.getLastName());
        } else {
            this.logger.logError("Student with ID " + id + " not found");
        }
        return student;
    }
}
