package com.baotrung.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baotrung.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return (List<Student>) sessionFactory.getCurrentSession().createCriteria(Student.class).list();
	}

	@Override
	public void deleteStudent(int id) {
		Student student = (Student)sessionFactory.getCurrentSession().load(Student.class,id);
		if(student!=null) {
			this.sessionFactory.getCurrentSession().delete(student);
		}
		
	}

	@Override
	public void createStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(student);
		return student;
	}
	
	

	

}
