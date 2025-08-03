package com.ritik.SpringJdbcDemo.service;

import com.ritik.SpringJdbcDemo.model.Student;
import com.ritik.SpringJdbcDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {




    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }


    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addstudent(Student s)
    {
         repo.save(s);

    }

    public List<Student> getAllStudents() {
       return repo.findAll();
    }
}
