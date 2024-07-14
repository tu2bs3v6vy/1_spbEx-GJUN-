package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Porder;

public interface PorderDao 
{
	//create
	void add(Porder p);
	
	//read
	List<Porder> selectAll();
	List<Porder> selectById(int id);
	
	//update
	void update(Porder p);
	
	//delete
	void delete(int id);
}