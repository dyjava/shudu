package com.godo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Util {

	public static String readLocalFile(String filepath,String code){
    	StringBuffer buf = new StringBuffer() ;
		try {
			InputStream is = Util.class.getResourceAsStream(filepath);
			InputStreamReader isr = new InputStreamReader(is,code);   
			BufferedReader br = new BufferedReader(isr);
			
			String record = "";
			while ((record = br.readLine()) != null) {
			    if(record.startsWith("#")){
				continue ;
			    }
			    buf.append(record.trim()) ;
			}
			is.close();
			isr.close();
			br.close();
			return buf.toString() ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		return "" ;
	}
    
    public static String[] parseTag(String content, String tag){
		final String _TAG_START = "<" + tag + ">";
		final String _TAG_END = "</" + tag + ">";

		ArrayList<String> results = new ArrayList<String>();

		int start = content.indexOf(_TAG_START);
		int end = 0;
		while (start >= 0) {
			end = content.indexOf(_TAG_END, start);
			if (end < start) {
				break;
			}
			String item = content.substring(start + _TAG_START.length(), end);
			start = content.indexOf(_TAG_START, end);

			results.add(item);
		}
		return (String[]) results.toArray(new String[0]);
	}
	
}
