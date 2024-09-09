package com.jdc.mkt;

//constant must be on top
// global variable can be declared
// method can be created
// constructor can be created

// interface absclass  enum

//obj    ->  no		yes		yes
//static -> yes		yes		yes
//abs 	 -> yes		yes		yes
//const	 -> no		no		yes

public enum Day {
	MON(1) {
		@Override
		public String getName() {
			return "Monday";
		}
	},
	TUE(2) {
		@Override
		public String getName() {
			return "Tuesday";
		}
	},
	WED(3) {
		@Override
		public String getName() {
			return "Wednesday";
		}
	},
	THUR(4) {
		@Override
		public String getName() {
			return "Thursday";
		}
	},
	FRI(5) {
		@Override
		public String getName() {
			return "Friday";
		}
	},
	SAT(6) {
		@Override
		public String getName() {
			return "Saturday";
		}
	},
	SUN(7) {
		@Override
		public String getName() {
			return "Sunday";
		}
	};

	public abstract String getName();

	private int number;

	Day(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

}
