package test;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddProductServlet extends HttpServlet 
{
	

public void doPost(HttpServletRequest req,HttpServletResponse res)  throws    	ServletException,   IOException{
	  
	  HttpSession hs=req.getSession(false);
	  
	  if(hs==null) {
		  
		  RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		  
		  rd.forward(req, res);
		  return;
	  }
	  
	  String uname=(String)hs.getAttribute("UserName");
	  
	  ArrayList products=(ArrayList)hs.getAttribute("products");
	  
	          if(products==null) {
	        	  products=new ArrayList();
	          }
	          
	          String[] pcodes=req.getParameterValues("products");
	     
			for(int i=0;i<pcodes.length;i++) {
				
				if(req.getParameter(pcodes[i]).equals(""))
					      
					continue;
				
				Product  p=new Product();
				p.code=pcodes[i];
				
				int j=products.indexOf(p);
				
				if(j!=-1) {
					p=(Product)products.get(j);
					
					p.gty+=Double.parseDouble(req.getParameter(pcodes[i]));
					
						}
				else {
					p.name=req.getParameter(pcodes[i]+"Name");
					
					p.qty=Double.parseDouble(req.getParameter(pcodes[i]));
					products.add(p);
				}
				
			} //end of for
			
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			out.println("<html> <head>");
			out.println("<title>Shpoing cart Example</title>");
			out.println("</head></html>");
			out.println("<table width='100%'  height='90%' border='2'>");
			out.println("<tr align='center");
			
			out.println("<td height='39' colspan='2'><strong><font size='5>MyShoping site</font></strong></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td width='18%'  height='500' valign='top'><p>&nbsp;</p>");
			
			out.println("<blockquote>");
			
			out.println("<p><a href=' "+res.encodeUrl("getProducts")+"' >View Products</a></p>");
			out.println("<p><a href=' "+res.encodeUrl("getCart")+"' >View cart Details</a></p>");
			out.println("<p><a href=' "+res.encodeUrl("logout")+"' >Logout</a></p>");
			
			out.println("</blockquote></td>");
			
			out.println("<td width='82%' align='left' valign='top'><p><font size='6' >Welcome, "+uname+"</font></p>");
			out.println("Products Added Successfully to your cart</td>");
			out.println("</tr>");
			out.println("<tr align='center'>");
			out.println("<td colspan='2'><em>&copy;copyright 2019-20</em></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</body></html>");
			out.flush();
			out.close();
	  }
  }
  


