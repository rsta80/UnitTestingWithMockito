package com.arst80.unittesting.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import com.arst80.unittesting.repository.ItemRepository;

import com.arst80.unittesting.model.Item;

@RunWith(SpringRunner.class)
public class ItemBusinessServiceImplTest {

	@InjectMocks
	private ItemBusinessServiceImpl business;
	
	@Mock
	private ItemRepository repository;
	
	@Test
	public void testRetreiveHardcodedItem() {
		assertEquals(1, business.retreiveHardcodedItem().getId());
		assertNotNull(business.retreiveHardcodedItem());
	}

	
	@Test
	public void testRetrieveAllItems() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10),
				new Item(3,"Item3",20,20)));
		assertEquals(100, business.retrieveAllItems().get(0).getValue());
		assertEquals("Item3", business.retrieveAllItems().get(1).getName());
	}

}
