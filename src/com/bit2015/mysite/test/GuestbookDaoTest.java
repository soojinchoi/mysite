package com.bit2015.mysite.test;

import java.util.List;

import com.bit2015.mysite.dao.GuestbookDao;
import com.bit2015.mysite.vo.GuestbookVo;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		
		InsertTest();//insert test
		getListTest();//getList test

	}
	
	public static void getListTest(){
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList();
		for(GuestbookVo vo : list){
			System.out.println(vo);
		}
	}
	
	public static void InsertTest(){
		GuestbookDao dao = new GuestbookDao();
		GuestbookVo vo = new GuestbookVo();
		vo.setName("아이유");
		vo.setPassword("1234");
		vo.setMessage("하이루");
		
		dao.insert(vo);
	}
	
	public static void DeleteTest(){
		GuestbookDao dao = new GuestbookDao();
		GuestbookVo vo = new GuestbookVo();
		
		dao.delete("6","1234");
		
	}

}
