package main;

import java.util.Arrays;

public class ArrStek {
	private Object[] dataArray;
	private int size; // розмір
	private int capacity;//ємність
	private final int DEFAULT_CAPACITY=20;//масів з 20 елем.
	private final int MAX_STACK_SIZE=Integer.MAX_VALUE-1;//макс. вел.
	
	public ArrStek() {
		dataArray=new Object[DEFAULT_CAPACITY];
		capacity=dataArray.length;
		size=0;
	}
	public void push(Object obj) {
		if(size>=capacity) {
			boolean resizeResult=upResize();
			if(!resizeResult) {
				throw new RuntimeException("Cant add element");
			}
		}
		dataArray[size]=obj;
		size+=1;
	}
			public boolean upResize() {
				if(capacity>=MAX_STACK_SIZE) {
					return false;
				}
				long newCapacityL=(capacity*3L)/2L+1L;
				int newCapacity=(newCapacityL<MAX_STACK_SIZE)?(int)newCapacityL:MAX_STACK_SIZE;
				dataArray=Arrays.copyOf(dataArray, newCapacity);
				capacity=newCapacity;
				return true;
			}
			 public Object pop() {
				 if(size==0) {
					 return null;
				 }
				 size-=1;
				 Object element=dataArray[size];
				 dataArray[size]=null;
				 return element;
			 }
			 public Object peek() {
				 if(size==0) {
					 return null;
				 }
				 return dataArray[size-1];
			 }
			 public int size() {
				 return size;
			 }
			 public void trimToSize() {
				 dataArray=Arrays.copyOf(dataArray,size);
				 capacity=dataArray.length;
			 }
			 public void clear() {
				 dataArray=new Object[DEFAULT_CAPACITY];
				 capacity=dataArray.length;
				 size=0;
			 }
			@Override
			public String toString() {
				String result="[";
				for(int i=0;i<size;i++) {
					if(i<size-1) {
						result+=dataArray[i]+", ";
						}else {
							result+=dataArray[i];
						}
				}
				return result+="]";
			} 
		
	}

