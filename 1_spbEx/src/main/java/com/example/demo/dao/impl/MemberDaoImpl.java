package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.MemberDao;
import com.example.demo.model.Member;

@Component
public class MemberDaoImpl implements MemberDao
{
	@Autowired
	JdbcTemplate jdbctemplate;//PreparedStatement
	
	@Override
	public void add(Member m) 
	{
		String sql="insert into member(name,username,password,address,phone)"
				+ "values(?,?,?,?,?)";
		
		jdbctemplate.update(sql, m.getName(),m.getUsername(),m.getPassword(),m.getAddress(),m.getPhone());
	}

	@Override
	public List<Member> selectAll() 
	{
		String SQL="select * from member";
		List<Member> l=jdbctemplate.query(SQL,new BeanPropertyRowMapper(Member.class));
		return l;
	}

	@Override
	public List<Member> selectMember(String username,String password) 
	{
		String SQL="select * from member where username=? and password=?";		
		List<Member> l=jdbctemplate.query(SQL,new BeanPropertyRowMapper(Member.class),username,password);		
		return l;
	}

	@Override
	public List<Member> selectUsername(String username) 
	{
		String SQL="select * from member where username=?";		
		List<Member> l=jdbctemplate.query(SQL,new BeanPropertyRowMapper(Member.class),username);		
		return l;
	}

	@Override
	public List<Member> selectById(int id) 
	{
		String SQL="select * from member where id=?";		
		List<Member> l=jdbctemplate.query(SQL,new BeanPropertyRowMapper(Member.class),id);		
		return l;
	}

	@Override
	public void update(Member m) 
	{
		String SQL="update member set name=?,address=? where id=?";	
		jdbctemplate.update(SQL,m.getName(),m.getAddress(),m.getId());
	}

	@Override
	public void delete(int id) 
	{
		String SQL="delete from member where id=?";
		jdbctemplate.update(SQL,id);
	}
}