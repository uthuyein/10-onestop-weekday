package com.jdc.mkt.composition;

//Has a relation
public class Main {
	public static void main(String[] args) {
		Bathroom room = new Bathroom();
		room.takeShower();
	}
}

class Bathroom{
	private Shower shower;
	public Bathroom() {
		shower = new Shower();
	}
	void takeShower() {
		shower.takeShower();
	}
}
class Shower{
	void takeShower() {
		System.out.println("Taking shower");
	}
}
