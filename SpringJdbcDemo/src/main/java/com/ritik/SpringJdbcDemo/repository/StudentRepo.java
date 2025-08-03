package com.ritik.SpringJdbcDemo.repository;

import com.ritik.SpringJdbcDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;


    public void save(Student s)
    {
        String sql="insert into student (rollno,sname,marks) values (?,?,?)";
        int row=jdbc.update(sql,s.getRollno(),s.getSname(),s.getMarks());
        System.out.println("Rows affected "+row);
;    }

    public List<Student> findAll()
    {

        String sql="select * from student";
        RowMapper<Student> mapper=new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s=new Student();
                s.setRollno(rs.getInt("rollno"));
                s.setSname(rs.getString("sname"));
                s.setMarks(rs.getInt("marks"));
                return s;

            }
        };
        return jdbc.query(sql,mapper);
    }
}
