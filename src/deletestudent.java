import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
public class deletestudent extends HttpServlet 
{
  protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
	  res.setContentType("text/html");
	  PrintWriter pw=res.getWriter();
	  String sid=req.getParameter("id");
	  try 
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/advjava","root","root1234");
		  String query="delete *from productinfo where id=?;";
		  PreparedStatement ps=cn.prepareStatement(query);
		  ps.setString(1, sid);
		  ps.executeUpdate();
		  pw.println("<h2 align='center' style='color:red;'>Student deleted Successfully..</h2>");
		  cn.close();
		  
	  }
	  catch(Exception ex)
	  {
		  System.out.println(ex);
	  }
	  
  }
}
