package com.jdc.mkt.collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<String> q1 = new ArrayDeque<String>();	
		Queue<String> q2 = new LinkedList<String>();
		Queue<String> q3 = new PriorityQueue<String>();
		Queue<String> q4 = new ArrayBlockingQueue<>(3);
		
				
		addData(q4);
		showElement(q4);
		System.out.println();
		
		removeData(q4);
		showElement(q4);
		System.out.println();
//		
		getData(q1);
		System.out.println();
		showElement(q1);
	}
	
	static void showElement(Queue<String> q) {
		for(String s :q) {
			System.out.println("element :"+s);
		}
	}
	
	static void getData(Queue<String> q) {
		//System.out.println(q.element());
		System.out.println(q.peek());
	}
	
	static void removeData(Queue<String> q) {
		q.remove();
		q.poll();
		q.remove();
		q.poll();
	}
	
	static void addData(Queue<String> q) {
		q.add("Andrew");
		q.add("William");
		q.add("John");
		q.offer("Nikole");
		q.offer("Marry");
	}
}
