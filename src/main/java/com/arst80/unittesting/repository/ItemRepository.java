package com.arst80.unittesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arst80.unittesting.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
}
