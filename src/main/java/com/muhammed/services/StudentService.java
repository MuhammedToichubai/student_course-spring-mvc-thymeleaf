package com.muhammed.services;

import com.muhammed.models.Course;
import com.muhammed.models.Student;
import com.muhammed.repositories.CourseRepository;
import com.muhammed.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author Muhammed Toichubai
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository,
                          CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findByCourseId(UUID courseId) {
        return studentRepository.findByCourseId(courseId);
    }

    @Transactional
    public void save(UUID courseId, Student student) {
        Course course = courseRepository.findById(courseId);

        student.setCourse(course);
        course.setStudent(student);

        studentRepository.save(student);
    }
}

