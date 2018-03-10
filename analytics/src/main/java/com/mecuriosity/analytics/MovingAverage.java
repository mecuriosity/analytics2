package com.mecuriosity.analytics;

import java.util.ArrayList;
import java.util.List;

public class MovingAverage {
	private List<Double> rawSeries;
	private List<Double> movingAverageSeries;
	private int periods;
	
	public MovingAverage(List<Double> rawSeries, int periods) {
		this.rawSeries = rawSeries;
		this.periods = periods;
	}
	
	public List<Double> calculateAndGetMovingAverage(){
		calculateMovingAverage();
		return movingAverageSeries;
	}
	
	private void calculateMovingAverage(){
		movingAverageSeries = new ArrayList<Double>();
		List<Double> valuesToAverage = new ArrayList<Double>();
		for(int i = 0; i < rawSeries.size(); i++){
			valuesToAverage.add(rawSeries.get(i));
			if(i > periods - 1){
				valuesToAverage.remove(0);
			}
			movingAverageSeries.add(average(valuesToAverage));
		}	
	}
	
	private double average(List<Double> values){
		double sum = 0;
		for(Double v : values){
			sum += v;
		}
		return sum/values.size();
	}
	
	
	

}
