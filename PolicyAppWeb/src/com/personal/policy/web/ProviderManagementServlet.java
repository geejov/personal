package com.personal.policy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.personal.policy.ErrorMessage;
import com.personal.policy.Provider;
import com.personal.policy.dao.ProviderDAO;

@SuppressWarnings("serial")
public class ProviderManagementServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String action = req.getParameter("action");
		System.out.println("Action : " + action);
		
		resp.setContentType("text/plain");
		
		if ( "Add Provider".equalsIgnoreCase(action)) {
			System.out.println("Add Provider");
			String provider_name = req.getParameter("provider_name");
			String provider_address = req.getParameter("provider_address");
			String provider_phone = req.getParameter("provider_phone");
			
			Provider p = new Provider();
			p.setName(provider_name);
			p.setAddress(provider_address);
			p.setPhone(provider_phone);
			ProviderDAO.createProvider(p);
			
			resp.sendRedirect("/providers.jsp");
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
	
}
