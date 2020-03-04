package info.inet;

import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SampleServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
         throws ServletException, IOException{
      
       
      
      //sendind response
     
         resp.setContentType("text/plain");
         resp.getWriter().write("Hello World! Maven Web Project Example. ");
         resp.getWriter().write("Hello World! Maven Web Project Example ");
         
      String id=req.getParameter("empId");
		String name=req.getParameter("empName")
         
         resp.getWriter().write("EMP ID : "+id);
         resp.getWriter().write("EMP Name : "+name);
   
       try {  
     resp.setContentType("text/plain");
      resp.getWriter().write("Hello World! Maven Web Project Example.");
      
      Class.forName("com.mysql.jdbc.Driver");  
      Connection con=DriverManager.getConnection(  
      "jdbc:mysql://172.17.0.1:3306/hello_java?useSSL=false","demo_java","1234"); 
          
      PreparedStatement pstmt=con.prepareStatement("insert into hello_java.emp values(?,?)");  
      pstmt.setInt(1,id);
          pstmt.setString(2,name);
      int updates = pstmt.executeUpdate();
          resp.getWriter().write("No Of records inserted : "+updates);
      
         
      } catch(Exception e){ 
         e.printStackTrace();
      }  
   }
}
