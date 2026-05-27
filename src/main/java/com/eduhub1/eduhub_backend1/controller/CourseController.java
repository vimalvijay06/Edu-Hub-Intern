package com.eduhub1.eduhub_backend1.controller;

import com.eduhub1.eduhub_backend1.component.Course;
import com.eduhub1.eduhub_backend1.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    
    private static List<Course> courseList = new ArrayList<>();
    
    static {
        courseList.add(new Course("CS101", "Introduction to Programming", 3));
        courseList.add(new Course("CS102", "Data Structures", 4));
        courseList.add(new Course("CS103", "Database Management", 3));
        courseList.add(new Course("CS104", "Web Development", 3));
        courseList.add(new Course("CS105", "Operating Systems", 4));
    }
    
    @GetMapping("/search/get-courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }
    
    @GetMapping("/get-course/{code}")
    public ResponseEntity<Course> getCourseByPathVariable(@PathVariable("code") String code) {
        for (Course course : courseList) {
            if (course.getCourseCode().equals(code)) {
                return ResponseEntity.ok(course);
            }
        }
        throw new ResourceNotFoundException("Course", "courseCode", code);
    }
    
    @GetMapping("/get-course")
    public ResponseEntity<Course> getCourseByRequestParam(@RequestParam("code") String code) {
        for (Course course : courseList) {
            if (course.getCourseCode().equals(code)) {
                return ResponseEntity.ok(course);
            }
        }
        throw new ResourceNotFoundException("Course", "courseCode", code);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        courseList.add(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{code}")
    public ResponseEntity<Course> updateCourse(@PathVariable("code") String code, @RequestBody Course updatedCourse) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equals(code)) {
                courseList.set(i, updatedCourse);
                return ResponseEntity.ok(updatedCourse);
            }
        }
        throw new ResourceNotFoundException("Course", "courseCode", code);
    }
    
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("code") String code) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equals(code)) {
                courseList.remove(i);
                return ResponseEntity.noContent().build();
            }
        }
        throw new ResourceNotFoundException("Course", "courseCode", code);
    }
}
