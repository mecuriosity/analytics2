package com.mecuriosity.analytics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Test {
	private static List<Double> testData = new ArrayList<Double>();
	private static List<Double> testResult;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//createRandomData();
		//testMovingAverage();
		//writeRawAndResult();
		MovingAverage ma = new MovingAverage();
		ma.setData(testData, 3);
		testObjectParse(ma, "runObjectTest");

	}
	
	private static void createRandomData(){
		for(int i = 0; i < 20; i++){
			testData.add(Math.random()*100);
		}
	}
	
	private static void testMovingAverage(){
		MovingAverage ma = new MovingAverage();
		ma.setData(testData, 3);
		testResult = ma.calculateAndGetMovingAverage();
	}
	
	private static void writeRawAndResult(){
		for(int i = 0; i < testResult.size(); i++){
			System.out.println(testData.get(i)+ " | " + testResult.get(i));
		}
	}
	
	private static void testObjectParse(Object o, String methodName){
		Class c = o.getClass();
		Method method;
		try {
			method = c.getMethod(methodName, null);
			System.out.println(method.getName());
			try {
				method.invoke(o, null);
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
			
		} catch (NoSuchMethodException e){
			e.printStackTrace();
		}
		
		
		
			
	
		
		
		
		//Method[] methods = c.getMethods();
//		for(Method m : methods){
//			System.out.println(m.getName());
//		}
	}

}
