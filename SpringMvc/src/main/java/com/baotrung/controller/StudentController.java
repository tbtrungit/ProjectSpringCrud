package com.baotrung.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baotrung.model.Student;
import com.baotrung.services.StudentServices;

@Controller
public class StudentController {
	@Autowired
	private StudentServices studentServices;
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Student st = new Student();
        model.addObject("student", st);
        model.setViewName("addStudent");
        return model;
    }
	
	@RequestMapping(value="/saveStudent",method=RequestMethod.POST)
	public String addStudent(@ModelAttribute("student")Student student) {
		if(student.getId()==0) {
			this.studentServices.createStudent(student);
		}else{
			this.studentServices.updateStudent(student);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String getAll(ModelMap map) {
		List<Student> student = studentServices.getAll();
		map.addAttribute("students",student);
		return "account";
	}
	@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.GET)
	public String deleteStudent(@PathVariable("id")int id) {
		studentServices.deleteStudent(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student st = studentServices.getStudentById(id);
        ModelAndView model = new ModelAndView("addStudent");
        model.addObject("student", st);
 
        return model;
    }
}
