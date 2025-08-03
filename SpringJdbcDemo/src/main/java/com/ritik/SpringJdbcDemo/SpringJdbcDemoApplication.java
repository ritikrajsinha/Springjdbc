package com.ritik.SpringJdbcDemo;

import com.ritik.SpringJdbcDemo.model.Student;
import com.ritik.SpringJdbcDemo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringJdbcDemoApplication.class, args);
		System.out.println("hello world");
		Student s1=context.getBean(Student.class);
		s1.setRollno(103);
		s1.setSname("Ritik");
		s1.setMarks(25);
		StudentService service=context.getBean(StudentService.class);


		service.addstudent(s1);
		List<Student> students=service.getAllStudents();
		for(int i=0;i<students.size();i++)
		{
			System.out.println("rollno: "+students.get(i).getRollno()+" name: " +students.get(i).getSname()+" marks: "+students.get(i).getMarks());

		}

	}

}
