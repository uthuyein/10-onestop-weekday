package com.jdc.mkt.array;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class DataArray implements Data<String> {

	private String[] arrays;

	@Override
	public void setData(String... arrays) {
		this.arrays = arrays;
	}

	@Override
	public String[] getData() {
		return arrays;
	}

	@Sort(Type.ASC)
	@Override
	public void sort() {
		try {
			Class<?> myClass = DataArray.class;
			Method m = myClass.getDeclaredMethod("sort");
			Sort s = m.getDeclaredAnnotation(Sort.class);
			
			if (null != s) {
				if (s.value() == Type.ASC) {
					Arrays.sort(arrays, Comparator.naturalOrder());
					
				} else {
					Arrays.sort(arrays, Comparator.reverseOrder());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int index) {
		String[] temp = new String[arrays.length - 1];
		int size = 0;
		
		if (arrays.length > index) {
			for (int i = 0; i < arrays.length; i++) {
				if (arrays[i] == arrays[index]) {
					i++;
				}
				temp[size++] = arrays[i];
			}
		}
		arrays = temp;
	}

}
