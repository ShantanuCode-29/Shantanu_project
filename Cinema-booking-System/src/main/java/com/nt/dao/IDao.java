package com.nt.dao;

import java.util.List;

import com.nt.model.Shows;

public interface IDao
{
List<Shows>getshowBycity(String city)throws Exception;
List<Shows>getshowsBytheater(String theater)throws Exception;
}
