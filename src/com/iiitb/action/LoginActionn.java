package com.iiitb.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.iiitb.dao.LoginDao;
import com.opensymphony.xwork2.ActionSupport;

public class LoginActionn extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	SessionMap<String, Object> session = null;	//may be as we have implemented SessionAware and have a SessionMap, struts2 internally sends saved attribute to servlet session object
	
	public String home()
	{
		return SUCCESS;
	}
	
	public String logout()
	{
		//HttpServletResponse response = ServletActionContext.getResponse();
		session.remove("user_name");
		session.remove("password");
		session.clear();
		session.invalidate();	
		addActionMessage("You Have Been Successfully Logged Out");
		return SUCCESS;
	}
	
	public String login()
	{
		LoginDao loginDao = new LoginDao();
		boolean result = false;
		
		result = loginDao.checkLoginStatus(getUserName(), getPassword());
		
		if(result)
		{
			session.put("user_name", getUserName());
			session.put("password", getPassword());
			return SUCCESS;
		}
		else
		{
			addActionError("Invalid userid or password");
			return LOGIN;
		}
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttributes)
	{
		this.session = (SessionMap<String, Object>)sessionAttributes;
	}
	
	public SessionMap<String, Object> getSession()
	{
		return session;
	}
	
}
