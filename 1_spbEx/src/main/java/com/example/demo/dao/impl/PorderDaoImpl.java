package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dao.PorderDao;
import com.example.demo.model.Porder;

@Component
public class PorderDaoImpl implements PorderDao
{
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public void add(Porder p) 
	{
		String SQL="insert into porder(name,a,b,c)"
				+ "values(?,?,?,?)";
		
		jdbctemplate.update(SQL,p.getName(),p.getA(),p.getB(),p.getC());
	}

	@Override
	public List<Porder> selectAll() 
	{
		String SQL="select * from porder";
		List<Porder> l=jdbctemplate.query(SQL,new BeanPropertyRowMapper(Porder.class));
		return l;
	}

	@Override
	public List<Porder> selectById(int id) 
	{
		String SQL="select * from porder where id=?";
		List<Porder> l=jdbctemplate.query(SQL,new BeanPropertyRowMapper(Porder.class),id);
		return l;
	}

	@Override
	public void update(Porder p) 
	{
		String SQL="update porder set a=?,b=?c=? where id=?";
		jdbctemplate.update(SQL,p.getA(),p.getB(),p.getC(),p.getId());	
	}

	@Override
	public void delete(int id) 
	{
		String SQL="delete from porder where id=?";
		jdbctemplate.update(SQL,id);
	}
}