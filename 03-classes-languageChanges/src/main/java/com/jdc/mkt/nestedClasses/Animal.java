package com.jdc.mkt.nestedClasses;

public class Animal {
	
	private static String name;
	private static  int age;
	
	@SuppressWarnings("unused")
	public void useLion() {
		Lion l = new Lion();
		l.age = 2;
		l.show();
		
		//use interface
		double data = 20;
		Tester t = new Tester() {

			@Override
			public void show() {
				System.out.println(data);
			}
			
		};
	}
	
	void createLocalClass() {
		final double data = 30 ;
		
		@SuppressWarnings("unused")
		class LocalClass{
			
			void useData() {
				System.out.println(data);
				
			}
		}
		System.out.println(data);
	}
	
		
	public	class Lion{
		private static String name;
		private int age;
		
		private void show() {
			System.out.println("Lion :"+name+"\t"+age);
		}
		public void doSomething() {
			System.out.println("Do something with lion ");
		}
	}
	
	public static class Cat{
		
		static void setCat() {
			 name = "ww";
			 age = 30;
		}
		
		public static void show() {
			System.out.println("Cat :"+name+"\t"+age);
		}
		
	}
}

interface Tester{
	int value = 30 ;
	
	void show();
}
