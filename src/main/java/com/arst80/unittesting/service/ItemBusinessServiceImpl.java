package com.arst80.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arst80.unittesting.model.Item;
import com.arst80.unittesting.repository.ItemRepository;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

	@Autowired
	private ItemRepository repository;

	@Override
	public Item retreiveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@Override
	public List<Item> retrieveAllItems() {

		List<Item> items = repository.findAll();
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}

		return items;
	}

}
