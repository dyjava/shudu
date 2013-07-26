package com.godo.dao;

import java.util.ArrayList;

import com.godo.domain.Item;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DaoFactoryTest extends TestCase {

	public void testGetThesis(){
		ArrayList<ArrayList<Item>> thesis = DaoFactory.getInstens().getThesis() ;
		Assert.assertEquals(thesis.size(),9) ;
		for(int i=0;i<9;i++){
			Assert.assertEquals(thesis.get(i).size(),9) ;
		}
	}
	
	public void testGetAnswer(){
		DaoFactory.getInstens().getThesis() ;
		ArrayList<ArrayList<Item>> answer = DaoFactory.getInstens().getAnswer() ;
		Assert.assertEquals(answer.size(),9) ;
		for(int i=0;i<9;i++){
			Assert.assertEquals(answer.get(i).size(),9) ;
		}
	}
}
