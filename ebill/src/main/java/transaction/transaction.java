package transaction;

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
@WebServlet("/verify3")
public class transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String t=request.getParameter("tid");
		String ma=request.getParameter("nam");
		String da=request.getParameter("date");
		Integer ad=Integer.parseInt(request.getParameter("amt"));
		Integer un=Integer.parseInt(request.getParameter("unit"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anjali44");		
			PreparedStatement ps=con.prepareStatement("insert into transaction values(?,?,?,?,?)");
			ps.setString(1,t);
			ps.setString(2,ma);
			ps.setString(3,da);
			ps.setInt(4,ad);
			ps.setInt(5,un);

			int b = ps.executeUpdate();	
			HttpSession s=request.getSession();
			response.sendRedirect("pay.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// TODO Auto-generated method stub
	}

}
