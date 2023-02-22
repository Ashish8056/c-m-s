import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
@WebServlet("/search-student")
public class searchstudent extends HttpServlet
{
  protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
	  res.setContentType("text/html");
	  String sid=req.getParameter("id");
	  PrintWriter pw=res.getWriter();
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/advjava","root","root1234");
		  String query="select *from productinfo where id=?";
		  PreparedStatement st=cn.prepareStatement(query);
		  st.setString(1,sid);
		  ResultSet rst=st.executeQuery();
		 
		  
		  if(rst.next())
		  { 
			  pw.println("<table  align='center' border='1' style='border-collapse:collapse;'>");
			  pw.println("<tr style='background-color:orange;'>");
			   pw.println("<th>Id</th>");
			   pw.println("<th>firstname</th>");
			   pw.println("<th>lastname</th>");
			   pw.println("<th>EmailId</th>");
			   pw.println("<th>DOB</th>");
			   pw.println("<th>CollegeName</th>");
			   pw.println("<th>City</th>");
			  pw.println("</tr>");
			  pw.println("<tr>");
			   pw.println("<th>"+rst.getString(1)+"</th>");
			   pw.println("<th>"+rst.getString(2)+"</th>");
			   pw.println("<th>"+rst.getString(3)+"</th>");
			   pw.println("<th>"+rst.getString(4)+"</th>");
			   pw.println("<th>"+rst.getString(5)+"</th>");
			   pw.println("<th>"+rst.getString(6)+"</th>");
			   pw.println("<th>"+rst.getString(7)+"</th>");
			  pw.println("</tr>");
			  pw.println("</table>");
			  
		  }
		  else
		  {
			  pw.println("<h2 style='color:red;margin-left:500px;margin-top:300px;'>Student record is not found in repositary</h2>");
		  }
		  
		  
	  }
	  catch(Exception ex)
	  {
		  System.out.println(ex);
	  }
	  
  }
}
