import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
@WebServlet("/add-student")
public class addCustomer extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String sid=req.getParameter("id");
		String sfirstname=req.getParameter("firstname");
		String slastname=req.getParameter("lastname");
		String semailid=req.getParameter("emailid");
		String sdob=req.getParameter("dob");
		String scollegename=req.getParameter("collegename");
		String scity=req.getParameter("city");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/advjava","root","root1234");
			String query="insert into productinfo values(?,?,?,?,?,?,?);";
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setString(1, sid);
			ps.setString(2, sfirstname);
			ps.setString(3,slastname);
			ps.setString(4,semailid);
			ps.setString(5,sdob);
			ps.setString(6, scollegename);
			ps.setString(7, scity);
			ps.executeUpdate();
			pw.println("<h1 style='color:red;'>Student data saved successfully</h1>");
			cn.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		
	}
   
}
