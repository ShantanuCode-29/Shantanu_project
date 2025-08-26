package com.nt.model;

import java.time.LocalTime;

import lombok.Data;
@Data
public class Shows
{
	  private String movieTitle;
	    private String theaterName;
	    private String city;
	    private LocalTime showTime;
}
