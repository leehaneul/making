import java.sql.*;


public class db {
 public static void main(String[] args)
 {
  
  try
  {
   Class.forName("org.gjt.mm.mysql.Driver");
   System.out.println("드라이버 검색 성공");
   
  }catch(ClassNotFoundException e)
  {
   System.out.println("드라이버 검색 실패");
  }
  Connection con = null;
  String url = "jdbc:mysql://localhost:3307/test";
  String user = "root";
  String pass = "ekfzhddl13";
  PreparedStatement ps = null;
  ResultSet rs = null;
  String sql = "select * from airplane";
  
  try
  {
   con = DriverManager.getConnection(url,user,pass);
   System.out.println("My-sql 접속 성공");
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while(rs.next())
   {
	   String name = rs.getString("aname");
	   System.out.println(name);
   }
  }catch(SQLException e)
  {
   System.out.println("My-sql 접속 실패");
  }
 }

}