package utilities;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array <T> implements Iterable <T>{
	
	private T[] arr;
	public int capacity;
	public int len;

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	public Array() { this(16); }
	public Array(int capacity) {
		if(capacity<0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
		this.capacity = capacity;
		this.arr = (T[]) new Object[capacity];
	}
	
	public int size() { return  len; }
	public boolean isEmpty() { return size()==0; }
	public T get(int index) { return arr[index]; }
	public void set(int index, T elem) { arr[index] = elem; }
	public void clear() {
		for(int i=0;i<capacity;i++) 
			arr[i]=null; 
		len=0;	
	}
	
	public void add(T ele) {
		if(len+1>=capacity) {
			if(capacity==0) {capacity *=2;}
			else {capacity*=2;}
			T[] new_arr = (T[]) new Object[capacity];
			for(int i =0;i<len;i++) { new_arr[i] = arr[i];}
			arr=new_arr;
		}
		arr[len++]=ele;
	}
	
	
}

