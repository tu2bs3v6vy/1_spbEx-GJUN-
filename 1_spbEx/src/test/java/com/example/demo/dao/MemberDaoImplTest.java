package com.example.demo.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.impl.MemberDaoImpl;
import com.example.demo.model.Member;

@SpringBootTest
public class MemberDaoImplTest 
{
	@Autowired
	MemberDaoImpl mdi;

	//@Test
	public void addTest()
	{
		Member m=new Member("student","YANLIN","1101","shulin","511");
		mdi.add(m);
		System.out.println("add success");
	}
	
	//@Test
	public void selectAllTest()
	{
		List<Member> l=mdi.selectAll();
		for(Member m:l)
		{
			System.out.println("id:"+m.getId()+"\tname:"+m.getName());
		}
	}
	
	//@Test
	public void selectMemberTest()
	{
		List<Member> l=mdi.selectMember("yuyu","1101");
		for(Member m:l)
		{
			System.out.println("id:"+m.getId()+"\tname:"+m.getName());	
		}
	}
	
	//@Test
	public void selectUsernameTest()
	{
		List<Member> l=mdi.selectUsername("yuyanlin");
		for(Member m:l)
		{
			System.out.println("id:"+m.getId()+"\tname:"+m.getName());
		}
	}
	
	//@Test
	public void selectByidTest()
	{
		List<Member> l=mdi.selectById(20);
		System.out.println(l.size());
		for(Member m:l)
		{
			System.out.println("id:"+m.getId()+"\tname:"+m.getName());		
		}
	}
	
	//@Test
	public void updateTest()
	{
		List<Member> l=mdi.selectById(16);
		Member[] m=l.toArray(new Member[1]);	
		m[0].setName("student");
		m[0].setAddress("南投");		
		mdi.update(m[0]);	
		System.out.println("update success");
	}
	
	@Test
	public void deleteTest()
	{
		mdi.delete(20);
		System.out.println("delete success");
	}
}