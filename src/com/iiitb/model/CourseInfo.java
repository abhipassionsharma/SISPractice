package com.iiitb.model;

public class CourseInfo
{
	private String courseName;
	private int courseId;
	private String faculty;
	private int semester;

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public int getCourseId()
	{
		return courseId;
	}

	public void setCourseId(int courseId)
	{
		this.courseId = courseId;
	}

	public String getFaculty()
	{
		return faculty;
	}

	public void setFaculty(String faculty)
	{
		this.faculty = faculty;
	}

	public int getSemester()
	{
		return semester;
	}

	public void setSemester(int semester)
	{
		this.semester = semester;
	}

}
