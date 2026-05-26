package com.eduhub1.eduhub_backend1.component;

import org.springframework.stereotype.Component;

@Component
public class CourseService {
    
    private final CourseRepository courseRepository;
    private final LoggerComponent logger;

    public CourseService(CourseRepository courseRepository, LoggerComponent logger) {
        this.courseRepository = courseRepository;
        this.logger = logger;
    }
    
    public String getCourse() {
        this.logger.logInfo("Fetching course data...");
        String courseData = this.courseRepository.fetchCourseData();
        this.logger.logInfo("Course data fetched successfully");
        return courseData;
    }
}
