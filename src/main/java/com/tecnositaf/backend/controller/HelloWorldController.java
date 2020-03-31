package com.tecnositaf.backend.controller;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	// returns the current date and time 
	@GetMapping("time/now")
	public String getHour () {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String resultDate = dateFormat.format(date);
		return resultDate;
	}
	
	// returns a list of 10 random elements
	@GetMapping("list/random")
	public int[] getRandom() {
		int [] result = new int [10];
		for(int i = 0; i<10; i++) {
			result [i] = randomInt(0,50);
		}
		return result ;
	}
	
	// returns a random int in range min - max 
	private int randomInt(int min, int max) {
		return (int) ((Math.random() * (max - min )) + min);
	}
	
	
}
