package com.baotrung.dao;

import java.util.List;

import com.baotrung.model.Student;

public interface StudentDao {
	public void createStudent(Student student);
	public List<Student> getAll();
	public void deleteStudent(int id);
	public Student getStudentById(int id);
	public Student updateStudent(Student student);

}
