package com.muhammed.controllers;

import com.muhammed.models.Course;
import com.muhammed.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Muhammed Toichubai
 */
@Controller
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @ModelAttribute("courseList")
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping
    public String findAll() {
        return "allCourses";
    }

    @GetMapping("/save")
    public String saveCoursePage(Model model) {

        model.addAttribute("emptyCourse", new Course());

        return "saveCoursePage";
    }

    @PostMapping("/save")
    public String saveCourse(Course course) {

        System.out.println(course);

        courseService.save(course);

        return "redirect:/api/courses";
    }
}

