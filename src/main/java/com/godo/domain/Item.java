package com.godo.domain;

public class Item {
	private int v ;
	private boolean canRead = true ;	//是否可修改，初始值不可修改，添加值可以修改
	private boolean isOver = false ;	//是否添加完毕，行、列或单元格验证通过后标志。
	
	public Item(){}
	public Item(int value){
		v = value ;
		canRead = false ;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public boolean isCanRead() {
		return canRead;
	}
	public void setCanRead(boolean canRead) {
		this.canRead = canRead;
	}
	public boolean isOver() {
		return isOver;
	}
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	
}
