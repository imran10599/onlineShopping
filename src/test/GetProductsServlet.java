package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetProductsServlet extends  HttpServlet
{
   private ProductsDAO ProductsDAO;

public void init() throws ServletException
{
	   ProductsDAO=new ProductsDAO();
	   }
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	
	HttpSession hs=req.getSession(false);
	
	if(hs==null) {
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, res);
		return;
	}
	String uname=(String)hs.getAttribute("UserName");
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	
	out.println("<html><head>");
	out.println("<title>My Shopping Cart</title>");
	out.println("</head><body>");
	out.println("<table width='100%' height='90' border='2'>");
	out.println("<tr  align='center'");
	
	out.println("<td height='39' colspan='2'><strong><font size='5'>MY SHOPPING CART</font></strong></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td width='18%' height='500' valign='top'><p>&nbsp;</p>");
	out.println("<blockquote>");
	
	out.println("<p><a href='"+res.encodeURL("getProducts")+ "'>");
	out.println("View Products</a></p>");
	
	out.println("<p><a href='"+res.encodeURL("getCart")+ "'>");
	out.println("View Cart Details</a></p>");
	
	out.println("<p><a href='"+res.encodeURL("logout")+ "'>");
	out.println("Logout</a></p>");
	
	out.println("</blockquote></td>");
	
	out.println("<td width='82%' align='left' valign='top'><p>");
	
	out.println("<font size='6' >Welcome, "+uname+"</font></p>");
	
	out.println("<form method='post' action='"+res.encodeUrl("addProducts")+"'>");
	
	out.println("<table width='100%' border='2'>");
	
	out.println("<tr>");
	
	out.println("<th width='8%'>Check</th>");
	out.println("<th width='24%'>Products Code</th>");
	out.println("<th width='24%'>Products Name</th>");
	out.println("<th width='28%'>Available Quantity</th>");
	out.println("<th width='20%'>Required Quantity</th>");
	out.println("</tr>");
	
Collection products=(Collection)hs.getAttribute("products");
	
	if(products==null) {
		
		out.println("<tr><td colspan='5' align='center'>");
		
		out.println("No Products Available");
		
		out.println("</td></tr>");
		
	}
	else {
		
		Iterator i=products.iterator();
		while(i.hasNext()) {
			Product p= (Product)i.next();
			out.println("<ta align='center'>");
			
			out.println("<input type='checkbox' name='products' value='"+p.getCode()+"'/>");
			
			out.println("<input type'hidden' name='"+p.getCode+"name'value="+p.getName()+"'/></td>");
			
			out.println("<td>"+p.getCode()+"</td>");
			out.println("<td>"+p.getName()+"</td>");
			out.println("<td>"+p.getQty()+"</td>");
			
			out.println("<td>");
			out.println("<input type='text' name='"+p.getCode+"'/>");
			
			out.println("</td></tr>");
	
}
}

               out.println("</table>");
                out.println("<br/><center>");
                out.println("<input type='submit' value='Add Products to Cart'/>");
               out.println("</center>");
                out.println("</form>");
                 out.println("</td></tr>");
                 
                 out.println("<tr align='center'>");
                 out.println("<td colspan='2'>");
                 
                 out.println("<td colspan='2' ><em>&copy;copyright 2019-20</em></td>");
             	out.println("</tr>");
             	out.println("</table>");
             	out.println("</body></html>");
             	out.flush();
             	out.close();             

}

      ProductsDAO productsdao;
}
