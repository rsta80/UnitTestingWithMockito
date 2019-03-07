package com.arst80.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMockTest {
	
	@SuppressWarnings("unchecked")
	List<String> mock = Mockito.mock(List.class);
	
	@Test
	public void size_basic() {		
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentbasic() {		
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {		
		when(mock.get(0)).thenReturn("Andres Andrade");
		assertEquals("Andres Andrade", mock.get(0));
		assertEquals(null, mock.get(1));
		
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("Andres Andrade");
		assertEquals("Andres Andrade", mock.get(0));
		assertEquals("Andres Andrade", mock.get(1));
		assertEquals("Andres Andrade", mock.get(10));		
	}
	
	@Test
	public void verificationBasics() {
		//SUT
		mock.get(0);
		mock.get(1);
		mock.get(1);
		
		//Verify
		verify(mock).get(0);		
		verify(mock, times(3)).get(anyInt());
		verify(mock, atLeast(2)).get(anyInt());
		verify(mock, atMost(5)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void argumentCapturing() {
		//SUT
		mock.add("anyString");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("anyString", captor.getValue());
		
	}
	
	@Test
	public void multipleArgumentCapturing() {
		//SUT
		mock.add("aString1");
		mock.add("aString2");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("aString1", allValues.get(0));
		assertEquals("aString2", allValues.get(1));
		
	}
	
	@Test
	public void mock() {
		ArrayList arrayListMock = Mockito.mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}
	
	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test1");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		arrayListSpy.add("Test3");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test3");
	}

}
