package com.jdc.mkt.dip;

public class Main {

	public static void main(String[] args) {
		Computer laptop = new Computer(new WirelessKeyBoard());
		laptop.useKeyboard();
	}
}

class StandardKeyBoard extends KeyBoard{
	String getKeyboard() {
		return "standard keyboard";
	}
}

class WirelessKeyBoard extends KeyBoard{
	String getKeyboard() {
		return "wireless keyboard";
	}
}

abstract class KeyBoard{
	abstract String getKeyboard();
}

class Computer{
	private KeyBoard keyboard;
	
	Computer(KeyBoard keyboard){
		this.keyboard = keyboard;
	}
	
	void useKeyboard() {
		System.out.println("Using :"+keyboard.getKeyboard());
	}
}
