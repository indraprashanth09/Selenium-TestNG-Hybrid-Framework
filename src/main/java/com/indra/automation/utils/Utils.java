package com.indra.automation.utils;

import java.util.Date;

public class Utils {
	
	public static final int IMPLICIT_WAIT_TIME=5;
	public static final int PAGE_WAIT_TIME=5;
	
	public static String generateEmailWithTimestamp()
	{
		Date date = new Date();	
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "indra"+timestamp+"@gmail.com";
	}

}
