package com.del.db;
import java.io.IOException;  
import java.io.PrintWriter;  
  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
@WebServlet("/servlet1")
public class FirstServlet extends HttpServlet {  

	private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException 
		{  
	  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("username");  
		    String p=request.getParameter("userpass");  
		          
		    if(LoginDao.validate(n, p)){ 
		    	out.print("Just to get tried of..");  
		        RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
		        rd.include(request,response);  
		    }  
		          
		    out.close();  
		}  
}