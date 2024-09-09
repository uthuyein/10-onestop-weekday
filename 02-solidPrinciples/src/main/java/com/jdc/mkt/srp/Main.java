package com.jdc.mkt.srp;

public class Main {

	public static void main(String[] args) {
		
	}
}

class GUI{
	Computer getFromUi() {
		Computer c = new Computer("Dell", "11gen");
		return c;
	}
	
	void showToUi() {
		Computer c = getFromUi();
		System.out.println("Showing to UI with name :%s and model :%s".formatted(c.getName(),c.getModel()));
	}
}
class Database{
	void saveToDb() {
		Computer c = new Computer("Mac","2012 mid");
		System.out.println("Saving to db with name :%s and model :%s".formatted(c.getName(),c.getModel()));
	}
	
}
class Computer{
	private String name;
	private String model;
	
	Computer(String name,String model){
		this.model = model;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getModel() {
		return model;
	}	
}
