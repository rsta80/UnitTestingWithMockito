package com.arst80.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.arst80.unittesting.data.DataService;
import com.arst80.unittesting.service.BusinessImpl;

class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3 };
		}
}

class DataServiceEmptyStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { };
		}
}

class DataServiceOneElementStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 1};
		}
}

public class BusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		BusinessImpl business = new BusinessImpl();		
		business.setDataService(new DataServiceStub());
		int actualREsult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualREsult);
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		BusinessImpl business = new BusinessImpl();		
		business.setDataService(new DataServiceEmptyStub());
		int actualREsult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualREsult);
	}

	@Test
	public void calculateSumUsingDataService_oneVale() {
		BusinessImpl business = new BusinessImpl();
		business.setDataService(new DataServiceOneElementStub());
		int actualREsult = business.calculateSumUsingDataService();
		int expectedResult = 1;
		assertEquals(expectedResult, actualREsult);
	}

}
