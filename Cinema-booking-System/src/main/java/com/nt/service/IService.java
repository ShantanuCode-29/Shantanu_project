package com.nt.service;

import java.util.List;

import com.nt.model.Shows;

public interface IService
{
List<Shows>showlist(String city)throws Exception;
List<Shows>showlistbytheater(String theater)throws Exception;
}
