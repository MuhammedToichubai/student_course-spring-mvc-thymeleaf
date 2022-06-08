package com.muhammed.repositories;

import com.muhammed.models.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.UUID;

/**
 * @author Muhammed Toichubai
 */
@Repository
public class CourseRepository {

    private final EntityManager entityManager;

    public CourseRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    public Course findById(UUID courseId) {
        return entityManager.find(Course.class, courseId);
    }

    public List<Course> findAll() {
        return entityManager
                .createQuery("select c from Course c", Course.class)
                .getResultList();
    }

    public void deleteById(UUID courseId) {
        entityManager.remove(entityManager.find(Course.class, courseId));
    }
}

