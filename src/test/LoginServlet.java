package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
UserDAO ud;
public void init() {
	
	ud=new UserDAO();
	
}

  public void doPsot(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
  {
	String uname=req.getParameter("uname");
	String pass =req.getParameter("pass");
	ud=new UserDAO();
  }
}
