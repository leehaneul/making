import java.sql.*;
import java.util.*;








public class db {
	
	public String name , identity_num , airplane_type1 , airplane_seat1 , start_point1 , arrival_point1 , start_time1;
	
	
	static void reservation (db s) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요");
		s.name = sc.next();
		System.out.print("주번을 입력하세요");
		s.identity_num = sc.next();
		System.out.print("비행기 종류를 선택해주세요");
		s.airplane_type1 = sc.next();
		System.out.print("좌석을 입력하세요");
		s.airplane_seat1 = sc.next();
		System.out.print("출발지역 입력하세요");
		s.start_point1 = sc.next();
		System.out.print("도착지역 입력하세요");
		s.arrival_point1 = sc.next();
		System.out.print("출발시간 을 입력해주세요");
		s.start_time1 = sc.next();
	}
	
	static void cancle (db s) {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("이름을 입력하세요");
		s.name = sc1.next();
		System.out.print("주번을 입력하세요");
		s.identity_num = sc1.next();
		
	}
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
  Statement stmt = null;

  
  String url = "jdbc:mysql://localhost:3307/test";
  String user = "root";
  String pass = "ekfzhddl13";
  PreparedStatement ps1 = null;
  PreparedStatement ps2 = null;
  PreparedStatement ps3 = null;
  PreparedStatement ps4 = null;
  PreparedStatement ps6 = null;
  
  ResultSet rs1 = null;
  ResultSet rs2 = null;
  ResultSet rs3 = null;
  ResultSet rs4 = null;
  ResultSet rs6 = null;
  
  String sql1 = "select * from airplane_time";
  String sql2 = "select * from reserved_client_table";
  String sql5="";
  

  

  

  try
  {

   con = DriverManager.getConnection(url,user,pass);
   stmt = con.createStatement();
   System.out.println("My-sql 접속 성공");
   ps1 = con.prepareStatement(sql1);
   ps2 = con.prepareStatement(sql2);
   rs1 = ps1.executeQuery();
   rs2 = ps2.executeQuery();
   
   
   
   while(rs1.next())
   {
	   String airplane_type = rs1.getString("airplane_type");
	   System.out.print(airplane_type); System.out.print("  ");
	   String start_time = rs1.getString("start_time");
	   System.out.print(start_time); System.out.print("  ");
	   String arrival_point = rs1.getString("arrival_point");
	   System.out.print(arrival_point); System.out.print("  ");
	   String start_point = rs1.getString("start_point");
	   System.out.print(start_point); System.out.println("");
   }
   
   db s = new db();
   
   reservation(s);
   
   rs1 = ps1.executeQuery();
   while(rs1.next())
   {
	   
	   String sql3 =" select * from ";
	   String airplane_type3 = rs1.getString("airplane_type");
	   String start_time3 = rs1.getString("start_time");
	   
	   String arrival_point3 = rs1.getString("arrival_point");
	   String start_point3 = rs1.getString("start_point");
	   
	   if( airplane_type3.compareTo(s.airplane_type1) == 0 )
		   if( start_time3.compareTo(s.start_time1) == 0 )
			   if( arrival_point3.compareTo(s.arrival_point1) == 0 )
				   if( start_point3.compareTo(s.start_point1) == 0 )
				   {
					    
					    sql3 = sql3 + airplane_type3;
					    
					    ps3 = con.prepareStatement(sql3);
					    rs3 = ps3.executeQuery();
				   }
				   else;
			   else;
		   else;
	   else;
	   
	   
	   
					    
					   
   }
   
					   
   while(rs3.next())
   {
	   
	   String non_occupied_seat = rs3.getString("non_occupied_seat");
	   if( non_occupied_seat.compareTo(s.airplane_seat1) == 0 )
		   {
		   		System.out.print("예약완료");
		   		String sql4 = "insert into reserved_client_table values(?,?,?,?,?,?)";
		   		
		   		try{
		 		   ps2 = con.prepareStatement(sql4);
		 		   ps2.setString(1, s.name);
		 		   ps2.setString(2, s.identity_num);
		 		   ps2.setString(4, s.airplane_seat1);
		 		   ps2.setString(5, s.start_point1);
		 		   ps2.setString(6, s.arrival_point1);
		 		   ps2.setString(3, s.airplane_type1);
		 		   
		 		   int n = ps2.executeUpdate();
		 		   if(n>0)
		 			   System.out.print("추가성공");
		 		   
		 	   }
		 	   catch(SQLException e)
		 	   {
		 		   e.printStackTrace();
		 	   }
		   	}
	   }
	  
   db s1 = new db();
   
   cancle(s1);
   
   
  
   while(rs2.next())
   {
	   
	   
	   String name5 = rs2.getString("name");
	   String r_r_number4 = rs2.getString("r_r_number");
	   
	   
	   
	   if( name5.compareTo(s1.name) == 0 )
		   if( r_r_number4.compareTo(s1.identity_num) == 0 )
			      {
			  
			   String ch= "delete from reserved_client_table where name='";
			   ch=ch+ s1.name;
			   ch=ch+"'";
			   System.out.print(ch);
			   
			   
			  int result = stmt.executeUpdate(ch);
			   
			   
					    
					    
				   }
				
		   else;
	   else;
	  
	  
   }
   
   
   
   }
  
  
  
  
  catch(SQLException e)
  {
   System.out.println("My-sql 접속 실패");
   }
  
 }

  
}