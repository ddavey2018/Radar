package com.esure.radar.fields;

public class Field<T> implements Value<T>{
	
	private T value;

	public Field(T value){
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
}
