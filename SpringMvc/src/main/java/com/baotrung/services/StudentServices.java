package com.baotrung.services;

import java.util.List;

import com.baotrung.model.Student;

public interface StudentServices {
	public void createStudent(Student student);
	public List<Student> getAll();
	public void deleteStudent(int id);
	public Student getStudentById(int id);
	public Student updateStudent(Student student);
}
