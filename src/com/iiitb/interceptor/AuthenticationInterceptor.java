package com.iiitb.interceptor;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor
{
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy()
	{
		//release resources here
	}

	@Override
	public void init()
	{
		//create resources here
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception
	{
		SessionMap<String, Object> sessionAttributes = (SessionMap<String, Object>)actionInvocation.getInvocationContext().getSession();
		String userName = (String)sessionAttributes.get("user_name");
		//String password = (String)sessionAttributes.get("password");
		
		if(userName == null || userName.isEmpty())
			return "loginAgain";	//define global result with this name
		else
			return actionInvocation.invoke();
	}

}
