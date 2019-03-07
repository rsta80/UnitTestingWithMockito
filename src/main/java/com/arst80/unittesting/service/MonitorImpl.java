package com.arst80.unittesting.service;

import java.util.ArrayList;
import java.util.List;

public class MonitorImpl {

	private Sensor sensor;
	private Alarm alarm;
	private int maxTemp;

	List<Integer> meassures = new ArrayList<Integer>();

	public void checkTemp() {

		int temp = sensor.getTemperature();

		if (temp <= getMaxTemp()) {
			meassures.clear();
		} else {
			meassures.add(temp);
		}

		if (meassures.size() == 3) {
			alarm.fire();
		}

	}

	public int getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(int maxTemp) {
		this.maxTemp = maxTemp;
	}

}
