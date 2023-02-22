import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
@WebServlet("/update-record")
public class UpdateRecord extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/advjava","root","root1234");
			String query="update productinfo set firstname=?,lastname=?,emailid=?,dob=?,collegename=?,city=?  where id='101';";
			PreparedStatement ps=cn.prepareStatement(query);
			
			ps.setString(1, req.getParameter("firstname"));
			ps.setString(2, req.getParameter("lastname"));
			ps.setString(3, req.getParameter("emailid"));
			ps.setString(4, req.getParameter("dob"));
			ps.setString(5, req.getParameter("collegename"));
			ps.setString(6, req.getParameter("city"));
			ps.executeUpdate();
			cn.close();
			pw.println("<h1>Student data has been updated successfully</h1>");
			pw.println("<a href='index.html'>Back</a>");
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	

}
