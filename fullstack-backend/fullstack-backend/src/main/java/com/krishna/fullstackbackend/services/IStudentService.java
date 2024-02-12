package com.krishna.fullstackbackend.services;

import com.krishna.fullstackbackend.model.Student;

import java.util.List;

public interface IStudentService {
    Student addStudent(Student student);
    List<Student> getStudent();
    Student updateStudent(Student student,Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);

}
