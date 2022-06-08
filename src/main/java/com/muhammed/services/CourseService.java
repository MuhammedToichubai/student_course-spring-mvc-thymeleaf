package com.muhammed.services;

import com.muhammed.models.Course;
import com.muhammed.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Muhammed Toichubai
 */
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public void save(Course course) {
        System.out.println(course.getName());
        courseRepository.save(course);
        System.out.println("course successfully saved!");
    }

}
