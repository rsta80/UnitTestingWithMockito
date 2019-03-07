package com.arst80.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.arst80.unittesting.data.DataService;
import com.arst80.unittesting.service.BusinessImpl;

@RunWith(MockitoJUnitRunner.class)
public class BusinessMockTest {

	@InjectMocks
	BusinessImpl business;
	@Mock
	DataService dataServiceMock;

	@Test
	public void calculateSumUsingDataService_basic() { 
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_oneVale() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1561 });
		assertEquals(1561, business.calculateSumUsingDataService());
	}

}
