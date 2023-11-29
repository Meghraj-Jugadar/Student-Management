package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.Register_bo;
import com.dao.Register_dao;

/**
 * Servlet implementation class Fetching
 */
@WebServlet("/Fetching")
public class Fetching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetching() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		List<Register_bo> fe=Register_dao.fetching();
		pw.print("<center>");
		
		pw.print("<a href=\"HomePage.html\">Home</a>");
		
		pw.print("<hr>");
		
		pw.print("Student Details <br><br>");
	    
	    pw.print("<table border='2px' width='400px'>");
	    
	    pw.print("<tr><th>Student ID</th><th>Name</th><th>Phone</th><th>Email</th><th>Edit</th><th>Delete</th></tr> ");
	    
	    for(Register_bo el:fe)
	    {
	    	pw.print("<tr><td>"+el.getStd_id()+"</td><td>"+el.getStd_name()+"</td><td>"+el.getStd_phone()+"</td><td>"+el.getStd_email()+"</td><td><a href='Edit.html'> edit </a></td><td><a href='DeleteServlet?id="+el.getStd_id()+"'>delete </a></td></tr>");
	    }
	    
	    pw.print("</table>");
	    
	    pw.print("</center>");
	    
	    pw.close();
	}

}
