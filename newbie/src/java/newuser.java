
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class newuser extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    PrintWriter out =response.getWriter();
        Connection con=null;
    PreparedStatement pst=null;
    int  rs=-1;
   String l =request.getParameter("a");
   String m = request.getParameter("b");
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","akashjain123");
pst=con.prepareStatement("insert into aj(username,password) values(?,?)");
pst.setString(1,l);
	pst.setString(2,m);
         rs=pst.executeUpdate();    
         out.println("Welcome to the newbie");
		


    }   catch (ClassNotFoundException | SQLException ex) {
        out.println("Exception is:"+ex);
    }
    }
}

           
        
        