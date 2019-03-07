package com.arst80.unittesting.controller.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssertStrictTrue() throws JSONException {
		
		String expectedResp = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		
		JSONAssert.assertEquals(expectedResp, actualResponse, true);
	}
	
	@Test
	public void jsonAssertStrictFalse() throws JSONException {
		
		String expectedResp = "{\"id\":1,\"name\":\"Ball\"}";
		
		JSONAssert.assertEquals(expectedResp, actualResponse, false);
	}
	
	@Test
	public void jsonAssertStrictFalseChangingContent() throws JSONException {
		
		String expectedResp = "{\"id\":1,\"price\":10,\"quantity\":100,\"name\":\"Ball\"}";
		
		JSONAssert.assertEquals(expectedResp, actualResponse, false);
	}
	
	@Test
	public void jsonAssertStrictTrueWhitoutEscapeCharacters() throws JSONException {
		
		String expectedResp = "{id:1,name:Ball,price:10,quantity:100}";
		
		JSONAssert.assertEquals(expectedResp, actualResponse, true);
	}
	
	

}
