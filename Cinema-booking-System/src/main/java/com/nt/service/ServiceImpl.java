package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IDao;
import com.nt.model.Shows;
@Service
public class ServiceImpl implements IService 
{
	@Autowired
	private IDao dao;

	@Override
	public List<Shows> showlist(String city) throws Exception {
		
		return dao.getshowBycity(city);
	}

	@Override
	public List<Shows> showlistbytheater(String theater) throws Exception {
		
		return dao.getshowsBytheater(theater);
	}

}
