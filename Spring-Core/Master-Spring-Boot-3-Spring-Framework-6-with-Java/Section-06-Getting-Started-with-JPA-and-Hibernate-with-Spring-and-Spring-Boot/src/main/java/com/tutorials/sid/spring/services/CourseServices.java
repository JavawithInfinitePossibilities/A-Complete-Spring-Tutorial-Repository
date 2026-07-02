package com.tutorials.sid.spring.services;

import com.tutorials.sid.spring.entity.Course;
import com.tutorials.sid.spring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kunmu On 02-07-2026
 */
@Service
public class CourseServices {

    @Autowired
    private CourseRepository courseRepository;

    public void saveCourse(List<Course> courses){
        courseRepository.saveAll(courses);
    }
    public void updateCourse(Course course){
        courseRepository.save(course);
    }
    public void deleteCourse(Course course){
        courseRepository.delete(course);
    }
    public List<Course> getCourse(){
        return courseRepository.findAll();
    }
    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElse(null);
    }
}
