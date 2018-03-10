package com.mecuriosity.analytics;

import java.util.ArrayList;
import java.util.List;

public class MovingAverageTest {
	private static List<Double> testData = new ArrayList<Double>();
	private static List<Double> testResult;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createRandomData();
		testMovingAverage();
		writeRawAndResult();

	}
	
	private static void createRandomData(){
		for(int i = 0; i < 20; i++){
			testData.add(Math.random()*100);
		}
	}
	
	private static void testMovingAverage(){
		MovingAverage ma = new MovingAverage(testData, 3);
		testResult = ma.calculateAndGetMovingAverage();
	}
	
	private static void writeRawAndResult(){
		for(int i = 0; i < testResult.size(); i++){
			System.out.println(testData.get(i)+ " | " + testResult.get(i));
		}
	}

}
