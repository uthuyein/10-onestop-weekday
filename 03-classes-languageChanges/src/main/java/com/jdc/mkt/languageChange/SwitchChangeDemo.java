package com.jdc.mkt.languageChange;

public class SwitchChangeDemo {

	String beforeChange(Day day ) {
		//java 10
		var  res = "";
		
		switch(day) {
			case MON:
			case TUE:
			case THUR:
			case FRI:
				res = "Full Day";
				break;
			case WED:
				res = "Half Day";
				break;
			case SAT:
			case SUN:
				res = "Off Day";
				break;
		}
		return res;
	}
	//java 14
	@SuppressWarnings("unused")
	String afterChange(Day d) {
		return switch(d) {
			case MON,TUE,THUR,FRI -> {
				int i = 0;
				yield "Full Day";
				}
			case WED -> "Half Day";
			case SAT,SUN -> "Off Day";
			default -> null;
		};
	}
}

enum Day{
	MON,TUE,WED,THUR,FRI,SAT,SUN;
}
