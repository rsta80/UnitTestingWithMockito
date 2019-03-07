package com.arst80.unittesting.business;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.arst80.unittesting.service.Alarm;
import com.arst80.unittesting.service.MonitorImpl;
import com.arst80.unittesting.service.Sensor;

@RunWith(MockitoJUnitRunner.class)
public class AlarmCheckTest {
	
	@Mock
	Sensor sensor;
	
	@Mock
	Alarm alarm;
	
	@InjectMocks
	MonitorImpl monitorMock;
	
	@Before
	public void before() {
		monitorMock.setMaxTemp(10);	
	}	
	
	/* JUnit 5: Display name
	 * Test case to verify if the alarm goes off when it recieves Max temp 3 times 
	 */
	@Test	
	public void checkSensorTemperatures() {
		
		
		
		when(sensor.getTemperature()).thenReturn(15);
		
		monitorMock.checkTemp();
		monitorMock.checkTemp();
		monitorMock.checkTemp();
		verify(sensor, times(3)).getTemperature();
		verify(alarm).fire();
	}
	
	/* JUnit 5: Display name
	 * Test case to verify if the alarm not goes off when it recieves Max temp 3 times not consecutives
	 */
	@Test	
	public void checkSensorNotConsecutiveMaxTemperatures() {
		
		when(sensor.getTemperature()).thenReturn(15);
		
		monitorMock.checkTemp();
		monitorMock.checkTemp();
		when(sensor.getTemperature()).thenReturn(5);
		monitorMock.checkTemp();
		verify(sensor, times(3)).getTemperature();
		verify(alarm, never()).fire();
	}	

}
