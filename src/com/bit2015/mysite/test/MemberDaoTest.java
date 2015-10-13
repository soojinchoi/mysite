package com.bit2015.mysite.test;

import com.bit2015.mysite.dao.MemberDao;
import com.bit2015.mysite.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {

		updateTest();
		
		//insertTest();

		//getTest();

	}
	
	public static void updateTest(){

		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		
		vo.setNo(2L);
		vo.setName("강소현");
		vo.setEmail("miso66@naver.com");
		vo.setPassword("1127");
		vo.setGender("female");

		dao.update(vo);
	}
	
	public static void getTest(){
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.get("cjy5166@naver.com", "12345");
		System.out.println(vo);
	}
	
	public static void insertTest(){
		
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setName("조진영");
		vo.setEmail("cjy5166@naver.com");
		vo.setPassword("12345");
		vo.setGender("male");
		
		dao.insert(vo);
	}

}
