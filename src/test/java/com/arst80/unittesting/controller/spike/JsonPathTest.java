package com.arst80.unittesting.controller.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	@Test
	public void learning() {
		String responseFromService = "[" + 
				"{\"id\":10000, \"name\":\"Pencil\",\"quantity\":5}," + 
				"{\"id\":10001, \"name\":\"Pen\",\"quantity\":10}," + 
				"{\"id\":10002, \"name\":\"Eraser\",\"quantity\":15}" + 
				"]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		int lenght = context.read("$.length()");
		assertThat(lenght).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		assertThat(ids).contains(10000,10001,10002);
		
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
	}

}
