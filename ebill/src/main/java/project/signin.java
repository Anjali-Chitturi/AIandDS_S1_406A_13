package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class signin
 */
@WebServlet("/verify2")
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String na=request.getParameter("na");
		String ma=request.getParameter("mail");
		String pa=request.getParameter("password");
		String ad=request.getParameter("adds");
		String po=request.getParameter("pho");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anjali44");		
			PreparedStatement ps=con.prepareStatement("insert into ebill values(?,?,?,?,?)");
			ps.setString(1,na);
			ps.setString(2,ma);
			ps.setString(3,pa);
			ps.setString(4,ad);
			ps.setString(5,po);

			int b = ps.executeUpdate();	
			HttpSession s=request.getSession();
			response.sendRedirect("home.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// TODO Auto-generated method stub
	}

}
