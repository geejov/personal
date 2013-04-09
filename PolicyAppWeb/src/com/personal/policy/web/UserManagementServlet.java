package com.personal.policy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gson.Gson;
import com.personal.policy.ErrorMessage;
import com.personal.policy.ResponseMessage;
import com.personal.policy.dao.UserDAO;
import com.personal.policy.webobjects.User;

@SuppressWarnings("serial")
public class UserManagementServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String action = req.getParameter("action");
		System.out.println("Action : " + action);
		
		resp.setContentType("text/plain");
		
		if ( "Add Subscriber".equalsIgnoreCase(action)) {
			System.out.println("Add Subscriber");
			String fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String subscriberId = req.getParameter("subscriberid");
			String ssn = req.getParameter("ssn");
			
			String userKey = createUser( fullName, email, subscriberId, ssn);
			System.out.println("created user " + userKey);
			
			resp.sendRedirect("/users.jsp");
		}
		if ( "signin".equalsIgnoreCase(action)) {
			System.out.println("Sign In");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			try{
				String userKey = signIn(email, password);
				ResponseMessage m = new ResponseMessage();
				m.setResponse(userKey);
				Gson gson = new Gson();
				String json = gson.toJson(m);
				resp.getWriter().print(json);
			}
			catch( Exception e) {
				ErrorMessage err = new ErrorMessage();
				err.setError(e.getMessage());
				Gson gson = new Gson();
				String json = gson.toJson(err);
				resp.getWriter().print(json);
				System.out.println(err.getError());
			}
		}
		else {
			ErrorMessage e = new ErrorMessage();
			e.setError("required parameter 'action'");
			Gson gson = new Gson();
			String json = gson.toJson(e);
			resp.getWriter().print(json);
			System.out.println(e.getError());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	private String createUser( String fullName, String email, String subscriberId, String ssn ) {
		
		User user = new User();
		user.setName(fullName);
		user.setEmail(email);
		user.setSubscriberId(subscriberId);
		user.setSsn(ssn);
		
		String userKey = UserDAO.createUser(user);
		return userKey;
	}
	
	private String signIn ( String email, String password ) throws Exception {
		User user = UserDAO.getUserByEmail(email);
		
		if ( user == null ) {
			throw new Exception("Sign in failed");
		}
		else if ( user.getEmail().equalsIgnoreCase(email) &&  user.getPassword().equals(password)) 
			return KeyFactory.keyToString(user.getKey());
		else
			throw new Exception("Sign in failed");
	}
	
}
