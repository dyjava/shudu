package com.godo.domain;

import java.util.ArrayList;

public class Data {

	private ArrayList<DataRow> shudu = new ArrayList<DataRow>() ;

	public ArrayList<DataRow> getShudu() {
		return shudu;
	}

	public void setShudu(ArrayList<DataRow> shudu) {
		this.shudu = shudu;
	}
	
	public ArrayList<ArrayList<Item>> getThesis(){
		ArrayList<ArrayList<Item>> list = new ArrayList<ArrayList<Item>>();
		for(DataRow row:shudu){
			String[] data = row.getData().split("") ;
			String[] flag = row.getFlag().split("") ;
			if(data.length<9 || flag.length<9){
				return list ;
			}
			ArrayList<Item> items = new ArrayList<Item>() ;
			for(int i=0;i<data.length;i++){
				if(data[i].trim().length()==0){
					continue ;
				}
				Item item = new Item() ;
				item.setV(Integer.parseInt(data[i])) ;
				if(flag[i].trim().equals("1")){
					item.setCanRead(false) ;
				} else {
					item.setCanRead(true) ;
				}
				items.add(item) ;
			}
			list.add(items) ;
		}
		return list ;
	}
}
