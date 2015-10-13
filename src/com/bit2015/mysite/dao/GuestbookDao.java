package com.bit2015.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2015.mysite.vo.GuestbookVo;

public class GuestbookDao {
	private Connection getConnection() throws SQLException{
		Connection con = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dbURL  = "jdbc:oracle:thin:@localhost:1521:xe";
			con =  DriverManager.getConnection ( dbURL, "webdb", "webdb" );
			
		}catch(ClassNotFoundException ex){
			System.out.println("드라이버 로딩 실패-"+ex);
		}
		return con;
	}
	
	public void delete(String num,String password){
	      try{
	         Connection con=getConnection();
	         Long no=Long.parseLong(num);
	         String sql="delete from guestbook where no=? and password=?";
	         PreparedStatement pstmt=con.prepareStatement(sql);
	         
	         pstmt.setLong(1, no);
	         pstmt.setString(2, password);
	         pstmt.executeUpdate();
	         
	         pstmt.close();
	         con.close();
	         
	      }catch(SQLException e){
	         System.out.println("SQL 오류-" + e);
	      }
	   }
	
	public void insert(GuestbookVo vo){
		try{
			Connection connection = getConnection();
			//3.Statement 준비
			String sql = "insert into guestbook values(guestbook_seq.nextval,?,?,?,SYSDATE)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			//4.binding
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());
			
			//5.query 실행
			pstmt.executeUpdate();
			
			//6.자원정리 (자원정리는 역순으로 한다)
			pstmt.close();
			connection.close();

		}catch(SQLException ex){
			System.out.println("SQL 오류-"+ex);
		}
	}
	
	public List<GuestbookVo> getList() {//테이블에 있는 모든 소스를 리스트로 가져온다
		
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		try{
			Connection con = getConnection();
			//3.Statement 생성
			Statement stmt = con.createStatement();
			
			//4.SQL문 실행
			String sql = "select * from GUESTBOOK order by reg_date desc";
			ResultSet rs = stmt.executeQuery(sql);
			
			//5.row 가져오기
			while( rs.next() ){
				Long no = rs.getLong(1);
				String name = rs.getString(2); 
				String password = rs.getString(3); 
				String message = rs.getString(4);
				String reg_Date = rs.getString(5);
				
				GuestbookVo vo = new GuestbookVo();	
				vo.setNo(no);						
				vo.setName(name);
				vo.setPassword(password);
				vo.setMessage(message);
				vo.setRegDate(reg_Date);
	
				list.add(vo); 
			}
			//6.자원정리 (자원정리는 역순으로 한다)
				rs.close();
				stmt.close();
				con.close();

		}catch(SQLException ex){
			System.out.println("SQL 오류-"+ex);
		}
		return list;
	}
	
	
}
