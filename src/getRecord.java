import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
@WebServlet("/get-record")
public class getRecord extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String sid=req.getParameter("id");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/advjava","root","root1234");
			PreparedStatement ps=cn.prepareStatement("select *from productinfo where id=?;");
			ps.setString(1,sid);
			ResultSet rst=ps.executeQuery();
			if(rst.next())
			{
				 pw.println("<form action='update-record'>");
					pw.println("<table border='1' align='center' style='border-collapse:collapse;'>");
					pw.println("<tr>");
					  pw.println("<th style='background-color:orange;'colspan='2' align='center'>Student</th>");
					  pw.println("<th></th>");
					pw.println("</tr>");
					
					pw.println("<tr>");
					  pw.println("<th>Student Id</th>");
					  pw.println("<th><input type='text' value="+rst.getString(1)+" name='firstname' readonly/></th>");
					pw.println("</tr>");
					
					pw.println("<tr>");
					  pw.println("<th>firstname</th>");
					  pw.println("<th>lastname</th>");
					pw.println("</tr>");
					pw.println("<tr>");
					  pw.println("<th><input type='text' value="+rst.getString(2)+" name='firstname'/></th>");
					  pw.println("<th><input type='text' value="+rst.getString(3)+" name='lastname'/></th>");
					pw.println("</tr>");
					
					pw.println("<tr>");
					  pw.println("<th>emailid</th>");
					  pw.println("<th>dob</th>");
					pw.println("</tr>");
					pw.println("<tr>");
					  pw.println("<th><input type='text' value="+rst.getString(4)+" name='emailid'/></th>");
					  pw.println("<th><input type='text' value="+rst.getString(5)+" name='dob'/></th>");
					pw.println("</tr>");
					
					pw.println("<tr>");
					  pw.println("<th>emailid</th>");
					  pw.println("<th>dob</th>");
					pw.println("</tr>");
					pw.println("<tr>");
					  pw.println("<th><input type='text' value="+rst.getString(4)+" name='emailid'/></th>");
					  pw.println("<th><input type='text' value="+rst.getString(5)+" name='dob'/></th>");
					pw.println("</tr>");
					
					pw.println("<tr>");
					  pw.println("<th>College Name</th>");
					  pw.println("<th>City</th>");
					pw.println("</tr>");
					pw.println("<tr>");
					  pw.println("<th><input type='text' value="+rst.getString(6)+" name='collegename'/></th>");
					  pw.println("<th><input type='text' value="+rst.getString(7)+" name='city'/></th>");
					pw.println("</tr>");
					
					pw.println("<tr>");
					  pw.println("<th></th>");
					  pw.println("<th><button type='submit'>update</button></th>");
					pw.println("</tr>");
				  pw.println("</table>");
			    pw.println("</form>");		
			}
			else
			{
				pw.println("<h1>Student of this id is not found</h1>");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
