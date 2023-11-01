package com.panicodes.cruddemo.dao;

import com.panicodes.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository//handles component scanning and also adds support for exception translation
public class StudentDAOImpl implements StudentDAO{

    //define field for Entity Manager
    private EntityManager entityManager;

    //inject Entity Manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findEntries() {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by lastName",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findEntriesWithLastName(String LastName) {
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE lastName =:theLastName",Student.class);
        theQuery.setParameter("theLastName",LastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        Student updatedStudent=entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void updateMultipleStudents() {
        int numberOfRowsUpdated=entityManager.createQuery("UPDATE Student SET lastName='TEST'").executeUpdate();
        System.out.println(numberOfRowsUpdated);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        Student theStudent=entityManager.find(Student.class,id);
//        Student theStudent=entityManager.

        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public void deleteMany() {
        int noOfRowsDeleted=entityManager.createQuery("DELETE FROM Student WHERE firstName='john'").executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAll() {
        int ans=entityManager.createQuery("DELETE from Student").executeUpdate();
        return ans;
    }

}
