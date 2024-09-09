package com.jdc.mkt.array;

public interface Data<T> {

	@SuppressWarnings("unchecked")
	void setData(T...t);
	T[] getData();
	void sort();
	void remove(int index);
}
