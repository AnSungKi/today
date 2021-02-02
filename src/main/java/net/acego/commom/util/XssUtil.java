package net.acego.commom.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class XssUtil {
	public static String clean(String str){
		String xssStr = str;
		xssStr = xssStr.replaceAll("\n", "#newLine#");
		xssStr = xssStr.replaceAll("<([가-힣0-9]+)>", "<#han#$1#han#>");
		
		boolean valid = Jsoup.isValid(xssStr, Whitelist.basic());
		if(!valid){
			xssStr = Jsoup.clean(xssStr, Whitelist.basic());
		}
		
		xssStr = xssStr.replaceAll("#newLine#", "\n");
		xssStr = xssStr.replaceAll("#han#", "");
		
		return xssStr;
	}
	
	public static String clean(String str, Whitelist white){
		String xssStr = str;
		xssStr = xssStr.replaceAll("\n", "#newLine#");
		xssStr = xssStr.replaceAll("<([가-힣0-9]+)>", "<#han#$1#han#>");
		
		boolean valid = Jsoup.isValid(xssStr, white);
		if(!valid){
			xssStr = Jsoup.clean(xssStr, white);
		}
		
		xssStr = xssStr.replaceAll("#newLine#", "\n");
		xssStr = xssStr.replaceAll("#han#", "");
		
		return xssStr;
	}
}
