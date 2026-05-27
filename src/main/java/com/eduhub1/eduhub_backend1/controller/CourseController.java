package com.eduhub1.eduhub_backend1.controller;

import com.eduhub1.eduhub_backend1.component.Course;
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
    
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseList, HttpStatus.OK);
    }
    
    @GetMapping("/course/{courseCode}")
    public ResponseEntity<Course> getCourseByPathVariable(@PathVariable String courseCode) {
        for (Course course : courseList) {
            if (course.getCourseCode().equals(courseCode)) {
                return ResponseEntity.ok(course);
            }
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/course")
    public ResponseEntity<Course> getCourseByRequestParam(@RequestParam String courseCode) {
        for (Course course : courseList) {
            if (course.getCourseCode().equals(courseCode)) {
                return ResponseEntity.ok(course);
            }
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        courseList.add(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    
    @PutMapping("/course/{courseCode}")
    public ResponseEntity<Course> updateCourse(@PathVariable String courseCode, @RequestBody Course updatedCourse) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equals(courseCode)) {
                courseList.set(i, updatedCourse);
                return ResponseEntity.ok(updatedCourse);
            }
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/course/{courseCode}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String courseCode) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseCode().equals(courseCode)) {
                courseList.remove(i);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
