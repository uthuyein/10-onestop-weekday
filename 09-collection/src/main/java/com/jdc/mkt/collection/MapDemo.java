package com.jdc.mkt.collection;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {

	static Map<Integer, Computer> treeMap; 
	static Map<Computer, Integer> treeMapTwo;
	
	public static void main(String[] args) {
		treeMap = new TreeMap<Integer, Computer>();
		setDataTreeMap(treeMap);
		getDataForTreeMap();
		
		treeMapTwo = new TreeMap<Computer, Integer>();
		setDataTreeMapTwo(treeMapTwo);
		getDataForTreeMapTwo();
	}
	
	static void setDataTreeMapTwo(Map<Computer, Integer> map) {
		var com = new Computer(3,"Lenovo");
		
		map.put( new Computer(2,"Dell"),1);
		map.put( new Computer(1,"Acer"),2);
		map.put( com,3);
		map.put( com,4);
	}
	
	static void setDataTreeMap(Map<Integer, Computer> map) {
		var com = new Computer(3,"Lenovo");
		
		map.put(1, new Computer(2,"Dell"));
		map.put(2, new Computer(1,"Acer"));
		map.put(3, com);
		map.put(4, com);
	}
	
	static void getDataForTreeMapTwo() {
		for(Map.Entry m: treeMapTwo.entrySet()) {
			System.out.println(m.getKey()+"\t"+m.getValue());
		}
	}
	
	static void getDataForTreeMap() {
		for(Map.Entry m: treeMap.entrySet()) {
			System.out.println(m.getKey()+"\t"+m.getValue());
		}
	}
}


