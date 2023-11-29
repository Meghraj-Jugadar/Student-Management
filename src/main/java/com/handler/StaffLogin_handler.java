package com.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Teach_Regist_dao;

/**
 * Servlet implementation class StaffLogin_handler
 */
@WebServlet("/StaffLogin_handler")
public class StaffLogin_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffLogin_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String id=request.getParameter("userId");
		String pass=request.getParameter("password");
		
		int status=Teach_Regist_dao.login(id, pass);
		
		if(status>0) {
			HttpSession session=request.getSession(true);
			session.setAttribute("id", id);
			response.sendRedirect("./StaffHomePage.html");
		}
		else {
			pw.print("Ok");
		}
		
	}

}
