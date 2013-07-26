package com.godo.dao;

import java.util.ArrayList;

import com.godo.domain.Data;
import com.godo.domain.Item;

public class DaoFactory {

	private static DaoFactory factory = new DaoFactory() ;
	private DaoFactory(){}
	private ArrayList<ArrayList<Item>> thesis ;
	private ArrayList<ArrayList<Item>> answer ;
	public static DaoFactory getInstens(){
		return factory ;
	}
	public ArrayList<ArrayList<Item>> getThesis(){
		if(thesis==null||answer==null){
			initData();
		}
		return thesis ;
	}
	public ArrayList<ArrayList<Item>> getAnswer(){
		return answer ;
	}
	
	public void initData(){
		System.out.println("init now ...") ;
		randomShudu() ;
//		thesis = new ArrayList<ArrayList<Item>>();
//		answer = new ArrayList<ArrayList<Item>>();
//		for(int i=0;i<9;i++){
//			ArrayList<Item> it = new ArrayList<Item>() ;
//			ArrayList<Item> items = new ArrayList<Item>() ;
//			for(int j=0;j<9;j++){
//				it.add(new Item()) ;
//				items.add(new Item(j+1)) ;
//			}
//			thesis.add(it) ;
//			answer.add(items) ;
//		}
////		Q10
//		thesis.get(0).set(5,new Item(7));
//		thesis.get(0).set(8,new Item(1));
//		thesis.get(1).set(0,new Item(6));
//		thesis.get(1).set(1,new Item(9));
//		thesis.get(1).set(3,new Item(5));
//		thesis.get(1).set(5,new Item(4));
//		thesis.get(1).set(6,new Item(2));
//		thesis.get(2).set(0,new Item(8));
//		thesis.get(2).set(2,new Item(1));
//		thesis.get(2).set(3,new Item(9));
//		thesis.get(2).set(8,new Item(3));
//		thesis.get(3).set(2,new Item(8));
//		thesis.get(3).set(3,new Item(3));
//		thesis.get(3).set(8,new Item(4));
//		thesis.get(4).set(2,new Item(4));
//		thesis.get(4).set(6,new Item(7));
//		thesis.get(5).set(0,new Item(7));
//		thesis.get(5).set(5,new Item(1));
//		thesis.get(5).set(6,new Item(3));
//		thesis.get(6).set(0,new Item(1));
//		thesis.get(6).set(5,new Item(6));
//		thesis.get(6).set(6,new Item(4));
//		thesis.get(6).set(8,new Item(9));
//		thesis.get(7).set(2,new Item(6));
//		thesis.get(7).set(3,new Item(2));
//		thesis.get(7).set(5,new Item(3));
//		thesis.get(7).set(7,new Item(7));
//		thesis.get(7).set(8,new Item(5));
//		thesis.get(8).set(0,new Item(2));
//		thesis.get(8).set(3,new Item(1));
	}

	private static ArrayList<Data> list;
	private void randomShudu(){
		if(list==null || list.size()==0){
			Parser parser = new ParserImp() ;
			list = parser.parserData() ;
		}
		int num = (int)(Math.random()*list.size()) ;
		Data data = list.get(num) ;
		thesis = data.getThesis() ;
		answer = data.getThesis() ;
		for(ArrayList<Item> item:thesis){
			for(Item it:item){
				if(it.isCanRead()){
					it.setV(0);
				}
			}
		}
	}
}
