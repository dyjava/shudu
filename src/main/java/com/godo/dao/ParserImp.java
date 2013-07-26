package com.godo.dao;

import java.util.ArrayList;

import com.godo.domain.Data;
import com.godo.domain.DataRow;
import com.godo.util.Util;

public class ParserImp implements Parser {

	public ArrayList<Data> parserData() {
		ArrayList<Data> list = new ArrayList<Data>() ;
		String content = Util.readLocalFile("/shudu.xml","utf-8") ;
		String[] shudus = Util.parseTag(content,"shudu") ;
		for(String shudu:shudus){
			Data d = new Data() ;
			String[] datas = Util.parseTag(shudu,"data")[0].split("#") ;
			String[] flags = Util.parseTag(shudu,"flag")[0].split("#") ;
			int count = 0;
			for(int i=0;i<datas.length;i++){
				String data=datas[i].trim() ;
				if(data.length()==0){
					continue ;
				}
				
				DataRow dr = new DataRow() ;
				dr.setId(count) ;
				dr.setData(data) ;
				dr.setFlag(flags[i]) ;
				count++;
				
				d.getShudu().add(dr) ;
			}
			if(d.getShudu().size()==9){
				list.add(d) ;
			}
		}
		return list;
	}
	
}
