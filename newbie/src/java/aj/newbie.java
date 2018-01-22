
package aj;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class newbie extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         PrintWriter out = response.getWriter(); 
        String x =request.getParameter("t1");
        String y =request.getParameter("t2");

    PreparedStatement pst=null;
      ResultSet rs=null;
	   try
		  {
                      Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection
		   ("jdbc:mysql://localhost:3306/akash","root","akashjain123");
                       pst=con.prepareStatement("select * from aj where username=? and password=?");
			  pst.setString(1,x);
                          pst.setString(2,y);
			  rs=pst.executeQuery();
			  if(rs.next())
                          {
				 out.println("Login Success!!");
			  }
else
                          {
                              out.println("Login failure");
                          }
		  }
		  catch(  ClassNotFoundException | SQLException e)
    {
    out.println("Exception is:=="+e)   ;
    }
 
        }
    

    }
    
    

    