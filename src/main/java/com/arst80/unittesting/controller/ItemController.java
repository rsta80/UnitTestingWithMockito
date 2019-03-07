package com.arst80.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arst80.unittesting.model.Item;
import com.arst80.unittesting.service.ItemBusinessService;

@RestController
public class ItemController {
	
	@Autowired
	ItemBusinessService businessService;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1,"Ball",10,100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		return businessService.retreiveHardcodedItem();
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems(){
		return businessService.retrieveAllItems();
	}
	

}
