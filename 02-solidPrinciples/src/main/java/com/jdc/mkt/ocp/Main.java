package com.jdc.mkt.ocp;

public class Main {

	public static void main(String[] args) {
//		HotelCharge charge = new HotelCharge();
//		double d = charge.getTotalCharge(new SingleRoom());
		
		Hotel hotel = new MasterRoom();
		System.out.println("Hotel charge : "+hotel.getCharge());
	}
}
class Hotel{
	public double getCharge() {
		return 15000;
	}
}
class SingleRoom extends Hotel{
	
}
class DoubleRoom extends Hotel{
	public double getCharge() {
		return 15000*2;
	}
}
class MasterRoom extends Hotel{
	public double getCharge() {
		return 15000*3;
	}
}

//break open/closed principle
class HotelCharge extends Hotel{
	
//	public double getTotalCharge(Hotel hotel) {
//		if(hotel instanceof SingleRoom) {
//			return getCharge();
//		}else if(hotel instanceof DoubleRoom) {
//			return getCharge()*2;
//		}
//		return 0.0;
//	}
}
