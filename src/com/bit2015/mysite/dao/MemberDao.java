package com.bit2015.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit2015.mysite.vo.MemberVo;

public class MemberDao {
	
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
	
	public void insert(MemberVo vo){//회원가입 메소드
		try{
			//1.getConnection
			Connection con = getConnection();
			
			//2.PrepareStatement
			String sql = "insert into member values(member_no_seq.nextval,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//3.binding
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			
			//4.execute SQL
			pstmt.executeUpdate();
			
			//5. clear resource
			pstmt.close();
			con.close();
			
		}catch(SQLException e){
			System.out.println("SQL error"+e);
			
		}
	}
	
	public void update(MemberVo vo){//회원정보수정 메소드
		try{
			//1.Connection
			Connection con = getConnection();
			
			//2.prepareStatemet
			String sql = "update member set name=?, email=?, password=?, gender=? where no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//3.binding
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			pstmt.setLong(5, vo.getNo());
			
			//4.execute
			pstmt.executeUpdate();
			
			//5.clear
			pstmt.close();
			con.close();
			
		}catch(SQLException e){
			System.out.println("sql error:"+e);
		}
	}
		
	public MemberVo get(String email, String password){//login할 때 사용되는 메소드
		MemberVo vo = null;
		try{
			//1.Connection
			Connection con = getConnection();
			
			//2.PrepareStatement
			String sql = "select no, name, email from member where email=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//3.binding
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			//4.execute
			ResultSet rs = pstmt.executeQuery();
			if( rs.next() ){
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String email_2 = rs.getString(3);
				
				vo = new MemberVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email_2);
			}
			
			//5.clear resource
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(SQLException e){
			System.out.println("SQL error"+e);
		}
		
		return vo;
	}
	
	public MemberVo get(Long no){
		MemberVo vo = null;
		
		
		return vo;
	}


}
