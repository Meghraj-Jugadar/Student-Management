package com.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.Teach_Regist_bo;
import com.dao.Register_dao;
import com.dao.Teach_Regist_dao;

/**
 * Servlet implementation class Teacher_Regist_handler
 */
@WebServlet("/Teacher_Regist_handler")
public class Teacher_Regist_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_Regist_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		HttpSession session=request.getSession(false);
		if(session.getAttribute("id")!=null) {
			Random random = new Random();
	        int min = 10000; // Minimum five-digit number
	        int max = 99999; // Maximum five-digit number

	        int randomNum = random.nextInt(max - min + 1) + min;
	        String name=request.getParameter("teach_name");
	        String email=request.getParameter("teach_email");
	        String phone=request.getParameter("teach_phone");
	        String addr=request.getParameter("teach_addr");
	        String pass=request.getParameter("teach_pass");
	        
	        Teach_Regist_bo trb=new Teach_Regist_bo(randomNum, name, email, phone, addr, pass);
	        
	        int status=Teach_Regist_dao.insert(trb);
			if(status>0) {
				pw.print("<center>");
				pw.print("<h2>Inserted Successfullly</h2>");
				pw.print("Your Id is -> ' "+randomNum+" '<br>");
				pw.print("<a href=\"HomePage.html\">Home</a>\r\n"
						+ "<a href=\"LoginFrm.html\">Login</a>");
				pw.print("<center>");
			}
			else {
				pw.print("Something is Wrong");
			}
		}
		else {
			request.setAttribute("msg", "Login Again...");
			response.sendRedirect("StaffLoginFrm.html");
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
