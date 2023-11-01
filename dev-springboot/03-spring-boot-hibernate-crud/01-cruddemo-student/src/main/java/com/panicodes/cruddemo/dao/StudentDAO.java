package com.panicodes.cruddemo.dao;

import com.panicodes.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findEntries();

    List<Student>findEntriesWithLastName(String LastName);

    void updateStudent(Student theStudent);

    void updateMultipleStudents();

    void deleteStudent(Integer id);
    void deleteMany();

    int deleteAll();
}
