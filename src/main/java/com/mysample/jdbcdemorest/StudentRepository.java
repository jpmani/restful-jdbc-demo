package com.mysample.jdbcdemorest;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	
	List<Student> students;

	public StudentRepository() {
		students = new ArrayList<Student>();
		
		Student student1 = new Student();
		student1.setName("M.Riya");
		student1.setDob("14-01-2015");
		student1.setId(100);
		student1.setStd("1'std");
		student1.setSubject("English");
		student1.setMark(75);
		
		Student student2 = new Student();
		student2.setName("G.Nila");
		student2.setDob("10-05-2015");
		student2.setId(101);
		student2.setStd("UKG");
		student2.setSubject("English");
		student2.setMark(70);
		
		students.add(student1);
		students.add(student2);
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public Student getStudent(int id) {
		
		for (Student stud : students) {
			if(stud.getId() == id) {
				return stud;
			}
		}
		return new Student();
	}

	public void createStudent(Student stud) {
		
		students.add(stud);
	}
	
}
