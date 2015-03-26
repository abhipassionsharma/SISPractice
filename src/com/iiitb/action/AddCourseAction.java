package com.iiitb.action;

import java.util.ArrayList;
import java.util.List;

import com.iiitb.dao.CourseDao;
import com.iiitb.model.CourseInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddCourseAction extends ActionSupport implements ModelDriven<CourseInfo>
{
	CourseInfo course = new CourseInfo();
	List<String> facultyList = new ArrayList<String>();
	
	CourseDao courseDao = new CourseDao();
	
	public String addCourse()
	{
		courseDao.addCourse(course);
		return SUCCESS;
	}
	
	public String loadFaculty()
	{
		setFacultyList(courseDao.getFacultyList());
		return SUCCESS;
	}
	
	public CourseInfo getCourse()
	{
		return course;
	}

	public void setCourse(CourseInfo course)
	{
		this.course = course;
	}

	public List<String> getFacultyList()
	{
		return facultyList;
	}

	public void setFacultyList(List<String> facultyList)
	{
		this.facultyList = facultyList;
	}

	@Override
	public CourseInfo getModel()
	{
		return course;
	}
	
}
