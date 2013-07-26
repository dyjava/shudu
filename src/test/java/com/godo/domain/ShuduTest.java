package com.godo.domain;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ShuduTest extends TestCase {
	private Shudu shudu = Shudu.getRandomShudu() ;
	public void testGetThesis(){
		ArrayList<ArrayList<Item>> thesis = shudu.getThesis() ;
		Assert.assertEquals(thesis.size(),9) ;
		for(int i=0;i<9;i++){
			Assert.assertEquals(thesis.get(i).size(),9) ;
		}
	}
}
