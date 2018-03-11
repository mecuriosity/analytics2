package com.mecuriosity.analytics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MovingAverageObjects {
	private List<Double> rawSeries;
	private List<Object> rawObjects;
	private List<Double> movingAverageSeries;
	private int periods;
	private Method getValueMethod;
	private Method setValueMethod;
	private Class<? extends Object> objectClass;
	
	public MovingAverageObjects(List<Object> rawObjects, String nameOfGetValueMethod, String nameOfSetValueMethod, int periods){
		this.rawObjects = rawObjects;
		this.periods = periods;
		objectClass = rawObjects.get(0).getClass();
		try {
			this.getValueMethod = objectClass.getMethod(nameOfGetValueMethod, null);
			this.setValueMethod = objectClass.getMethod(nameOfSetValueMethod, null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}

	public void runObjectTest(){
		System.out.println("I am running from Moving Average");
	}
	
	public List<Double> calculateAndGetMovingAverage(){
		calculateMovingAverageObjects();
		return movingAverageSeries;
	}
	
	private void calculateMovingAverageObjects(){
		List<Double> valuesToAverage = new ArrayList<Double>();
		for(int i = 0; i < rawObjects.size(); i++){
			try {
				valuesToAverage.add((Double) getValueMethod.invoke(rawObjects.get(i), null));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i > periods - 1){
				valuesToAverage.remove(0);
			}
			try {
				setValueMethod.invoke(rawObjects.get(i), average(valuesToAverage));
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	private List<Object> getResult(){
		return rawObjects;
	}
	

	
	private double average(List<Double> values){
		double sum = 0;
		for(Double v : values){
			sum += v;
		}
		return sum/values.size();
	}

}
