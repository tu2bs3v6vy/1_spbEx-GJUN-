package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Member;

public interface MemberDao 
{
	//create
	void add(Member m);
	
	//read
	List<Member> selectAll();
	List<Member> selectMember(String username,String password);
	List<Member> selectUsername(String username);
	List<Member> selectById(int id);
	
	//update
	void update(Member m);
	
	//delete
	void delete(int id);
}