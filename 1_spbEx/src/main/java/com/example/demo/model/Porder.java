package com.example.demo.model;

import lombok.Data;

@Data
public class Porder {
	private Integer id;
	private String name;
	private Integer a;
	private Integer b;
	private Integer c;
	
	public Porder(String name,Integer a,Integer b,Integer c) 
	{
		super();
		this.name=name;
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public Porder() 
	{
		super();
	}
}