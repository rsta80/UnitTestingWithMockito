package com.arst80.unittesting.service;

import java.util.List;

import com.arst80.unittesting.model.Item;

public interface ItemBusinessService {

	Item retreiveHardcodedItem();

	public List<Item> retrieveAllItems();

}
