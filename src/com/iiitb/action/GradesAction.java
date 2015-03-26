package com.iiitb.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.iiitb.dao.CourseDao;
import com.iiitb.dao.GradesDao;
import com.iiitb.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

public class GradesAction extends ActionSupport
{
	List<String> studentList = new ArrayList<String>();
	List<String> courseList = new ArrayList<String>();
	List<String> gradeList = new ArrayList<String>();
	
	private String student;
	private String course;
	private String grade;
	
	public String loadFields()
	{
		UserDao userDao = new UserDao();
		setStudentList(userDao.getStudentList());
		
		CourseDao courseDao = new CourseDao();
		setCourseList(courseDao.getCourseList());
		
		String[] grades = {"A", "A-", "B+", "B", "B-", "C+", "C", "D", "F"};
		setGradeList(Arrays.asList(grades));
		return SUCCESS;
	}
	
	public String assignGrades()
	{
		GradesDao gradesDao = new GradesDao();
		gradesDao.assignGrades(getStudent(), getCourse(), getGrade());
		return SUCCESS;
	}

	public List<String> getStudentList()
	{
		return studentList;
	}

	public void setStudentList(List<String> studentList)
	{
		this.studentList = studentList;
	}

	public List<String> getCourseList()
	{
		return courseList;
	}

	public void setCourseList(List<String> courseList)
	{
		this.courseList = courseList;
	}

	public List<String> getGradeList()
	{
		return gradeList;
	}

	public void setGradeList(List<String> gradeList)
	{
		this.gradeList = gradeList;
	}

	public String getStudent()
	{
		return student;
	}

	public void setStudent(String student)
	{
		this.student = student;
	}

	public String getCourse()
	{
		return course;
	}

	public void setCourse(String course)
	{
		this.course = course;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}
}
