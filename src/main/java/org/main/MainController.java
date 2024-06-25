package org.main;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mycookie")
public class MainController extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse rep)throws ServletException {
		
		try(PrintWriter out=rep.getWriter()){
		String name=req.getParameter("data");
		out.println("hello : "+name);
		
		Cookie cookie=new Cookie("mycookie", name);
		cookie.setMaxAge(1000);
		
		rep.addCookie(cookie);
		
		out.println("Hi Your Cookie is Added..");
		out.println(name);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
