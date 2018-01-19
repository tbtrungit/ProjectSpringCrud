package com.baotrung.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baotrung.dao.StudentDao;
import com.baotrung.model.Student;

@Service
@Transactional
public class StudentServicesImpl implements StudentServices {
	@Autowired
	private StudentDao studentDao;

	@Transactional
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return studentDao.getAll();
	}
	@Transactional
	@Override
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
		
	}
	@Transactional
	@Override
	public void createStudent(Student student) {
		studentDao.createStudent(student);
		
	}
	@Transactional
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(id);
	}
	@Transactional
	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}

}
