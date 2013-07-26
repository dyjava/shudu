package com.godo.domain;

import java.util.ArrayList;
import java.util.HashSet;

import com.godo.dao.DaoFactory;

public class Shudu {

	private ArrayList<ArrayList<Item>> thesis ;
	private ArrayList<ArrayList<Item>> answer ;
	private static Shudu shudu = new Shudu();;
	private Shudu(){}
	public static Shudu getRandomShudu(){
		if(shudu!=null && shudu.thesis!=null && shudu.answer!=null){
			return shudu ;
		}
		if(shudu.flush()){
			return shudu ;
		}
		return null ;
	}
	
	public boolean flush(){
		System.out.println("flush ...");
		shudu = new Shudu();
		ArrayList<ArrayList<Item>> q = DaoFactory.getInstens().getThesis() ;
		ArrayList<ArrayList<Item>> a = DaoFactory.getInstens().getAnswer() ;
		return shudu.init(q, a);
	}
	
	/**
	 * 初始化数据
	 * 初始化命题和答案
	 * @param src
	 * @return
	 */
	private boolean init(ArrayList<ArrayList<Item>> q,ArrayList<ArrayList<Item>> a){
		if(q.size()!=9 || a.size()!=9){
			return false ;
		}
		for(int i=0;i<q.size();i++){
			if(q.get(i).size()!=9){
				return false ;
			}
		}
		for(int i=0;i<a.size();i++){
			if(a.get(i).size()!=9){
				return false ;
			}
		}
		thesis = q ;
		answer = a ;
		return true ;
	}
	
	/**
	 * 检验单个值是否冲突
	 * @param row 行
	 * @param col 列
	 * @param value
	 * @return
	 */
	public boolean checkItem(int row,int col,int value){
//		check row
		ArrayList<Item> rowItem = thesis.get(row) ;
		for(int i=0;i<9;i++){
			if(rowItem.get(i).getV()==value){
				return false ;
			}
		}
//		check col
		for(int i=0;i<9;i++){
			if(thesis.get(i).get(col).getV()==value){
				return false ;
			}
		}
//		check item
		int row_begin = 0 ;
		int col_begin = 0 ;
		if(row>=6){
			row_begin = 6 ;
		} else if(row>=3){
			row_begin = 3 ;
		}
		if(col>=6){
			col_begin = 6 ;
		} else if(col>=3){
			col_begin = 3 ;
		}
		for(int r=row_begin;r<row_begin+3;r++){
			rowItem = thesis.get(r) ;
			for(int c=col_begin;c<col_begin+3;c++){
				if(rowItem.get(c).getV()==value){
					return false ;
				}
			}
		}
		
		return true ;
	}
	
	/**
	 * 点击放置数据
	 * @param row
	 * @param col
	 * @param value
	 */
	public void put(int row,int col,int value){
		ArrayList<Item> rowItem = thesis.get(row) ;
		Item item = new Item() ;
		item.setV(value) ;
		rowItem.set(col, item) ;
		thesis.set(row, rowItem) ;
		markOver() ;
	}

	/**
	 * 点击消除数据
	 * @param row
	 * @param col
	 */
	public void clear(int row,int col){
		ArrayList<Item> rowItem = thesis.get(row) ;
		rowItem.set(col, new Item()) ;
		thesis.set(row, rowItem) ;
		markOver() ;
	}

	/**
	 * 标记over字段
	 * @return
	 */
	private void markOver(){
		//全部初始化over标志
		for(ArrayList<Item> itemlist:thesis){
			for(Item item:itemlist)
			item.setOver(false) ;
		}
		
		HashSet<Integer> set = new HashSet<Integer>() ;
		//check row
		for(ArrayList<Item> itemlist:thesis){
			set = new HashSet<Integer>() ;
			for(Item item:itemlist){
				set.add(item.getV()) ;
			}
			if(set.size()==9 && !set.contains(0)){
				for(Item item:itemlist){
					item.setOver(true) ;
				}
			}
		}
		
		//check col
		for(int i=0;i<9;i++){
			set = new HashSet<Integer>() ;
			for(ArrayList<Item> item:thesis){
				set.add(item.get(i).getV()) ;
			}
			if(set.size()==9 && !set.contains(0)){
				for(ArrayList<Item> item:thesis){
					item.get(i).setOver(true) ;
				}
			}
		}
		//check item table
		for(int r=0;r<3;r++){
			for(int c=0;c<3;c++){
				int row_ ;
				int col_ ;
				set = new HashSet<Integer>() ;
				HashSet<Item> itemSet = new HashSet<Item>() ;
				for(int i=0;i<3;i++){
					row_ = r*3+i ;
					for(int j=0;j<3;j++){
						col_= c*3+j ;
						itemSet.add(thesis.get(row_).get(col_)) ;
						set.add(thesis.get(row_).get(col_).getV()) ;
					}
				}
				
				//满足要求的voer字段赋值
				if(set.size()==9 && !set.contains(0)){
					for(Item item:itemSet){
						item.setOver(true) ;
					}
				}
			}
		}
		
	}
	
	/**
	 * 检测是否完成
	 * 根据over字段检测
	 * @return
	 */
	public boolean checkThesis(){
		for(ArrayList<Item> itemlist:thesis){
			for(Item item:itemlist){
				if(!item.isOver()){
					return false ;
				}
			}
		}
		return true ;
	}
	
	public ArrayList<ArrayList<Item>> getAnswer(){
		return answer ;
	}
	public ArrayList<ArrayList<Item>> getThesis(){
		return thesis ;
	}
}
