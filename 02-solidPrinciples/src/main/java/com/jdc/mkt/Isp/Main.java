package com.jdc.mkt.Isp;

public class Main {
	public static void main(String[] args) {
		
	}
}

interface Parent{
	void useChildA();
	
}

interface ParentTwo{
	void useChildB();
}

class ChildA implements Parent,ParentTwo{

	@Override
	public void useChildA() {
		System.out.println("Use Child A");
	}

	@Override
	public void useChildB() {
		System.out.println("Use Child B");
	}
	
}
class ChildB implements ParentTwo{

//	@Override
//	public void useChildA() {
//		//Didn't use for ChildB.		
//	}

	@Override
	public void useChildB() {
		System.out.println("Use Child B");
	}}

class ChildC implements Parent{

	@Override
	public void useChildA() {
		//Didn't use for ChildC.		
	}

}
