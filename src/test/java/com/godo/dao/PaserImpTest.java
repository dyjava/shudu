package com.godo.dao;

import java.util.ArrayList;

import com.godo.domain.Data;
import com.godo.domain.Item;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PaserImpTest extends TestCase {

	public void testParserData(){
		ArrayList<Data> list = new ParserImp().parserData() ;
		Assert.assertTrue(list.size()>1) ;
		System.out.println("shudu size:"+list.size()) ;
		for(Data data:list){
			Assert.assertEquals(data.getShudu().size(),9) ;
			ArrayList<ArrayList<Item>> thesis = data.getThesis() ;
			Assert.assertEquals(thesis.size(),9) ;
			for(ArrayList<Item> item:thesis){
				Assert.assertEquals(item.size(),9) ;
			}
		}
	}
}
