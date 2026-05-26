package com.eduhub1.eduhub_backend1.controller;

import com.eduhub1.eduhub_backend1.component.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/get-course")
    public String getCourse() {
        return this.courseService.getCourse();
    }
}
