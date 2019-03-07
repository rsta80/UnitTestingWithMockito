package com.arst80.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.arst80.unittesting.service.BusinessImpl;

public class BusinessTest {

	@Test
	public void calculateSum_basic() {
		BusinessImpl business = new BusinessImpl();
		int actualREsult = business.calculateSum(new int[] {1, 2, 3});
		int expectedResult = 6;
		assertEquals(expectedResult, actualREsult);
	}
	
	@Test
	public void calculateSum_empty() {
		BusinessImpl business = new BusinessImpl();
		int actualREsult = business.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualREsult);
	}
	
	@Test
	public void calculateSum_oneVale() {
		BusinessImpl business = new BusinessImpl();
		int actualREsult = business.calculateSum(new int[] {159});
		int expectedResult = 159;
		assertEquals(expectedResult, actualREsult);
	}

}
