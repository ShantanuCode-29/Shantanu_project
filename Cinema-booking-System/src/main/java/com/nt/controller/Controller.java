package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.model.Shows;
import com.nt.service.IService;



@Component("controller")
public class Controller 
{
	@Autowired
private IService service;


public List<Shows>fetchListbycity(String city) throws Exception
{
	List<Shows> showlist = service.showlist(city);
	return showlist;
}
public List<Shows>listbytheater(String theater)throws Exception
{
	List<Shows> showlistbytheater = service.showlistbytheater(theater);
	
	return showlistbytheater;
}
}
