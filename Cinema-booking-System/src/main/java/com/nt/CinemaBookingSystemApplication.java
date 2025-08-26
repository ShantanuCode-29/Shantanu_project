package com.nt;

import com.nt.controller.Controller;
import com.nt.model.Shows;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CinemaBookingSystemApplication
{

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(CinemaBookingSystemApplication.class, args);
		Controller c1 = context.getBean("controller", Controller.class);
		Scanner sc= new Scanner(System.in);
//		System.out.println("enter the city name");
//		 String city=sc.nextLine();
		System.out.println("enter the theater name");
		String theater=sc.nextLine();
		try {
			List<Shows> list = c1.listbytheater(theater);
			for (Shows show : list) {
			    System.out.println("Movie: " + show.getMovieTitle()+ 
			                       ", Theater: " + show.getTheaterName()+ 
			                       ", Time: " + show.getShowTime()+
			                       ",  city: "+show.getCity());
			}

		} catch (Exception e) {
			
			 e.printStackTrace();
		}
		sc.close();
		((ConfigurableApplicationContext)context).close();
	}

}
