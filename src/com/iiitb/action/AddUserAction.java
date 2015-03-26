package com.iiitb.action;

import com.iiitb.dao.UserDao;
import com.iiitb.model.CourseInfo;
import com.iiitb.model.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddUserAction extends ActionSupport implements ModelDriven<Student>
{
	Student student = new Student();
	
	public String addUser()
	{
		System.out.println(student.getImagePath());
		UserDao userDao = new UserDao();
		if(userDao.addUser(student))
			return SUCCESS;
		else
			return ERROR;
	}
	
	public Student getStudent()
	{
		return student;
	}


	public void setStudent(Student student)
	{
		this.student = student;
	}


	@Override
	public Student getModel()
	{
		return student;
	}

}
