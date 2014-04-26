package com.copac.loveletter;


public class Card {
	String name;
	Integer value;
	
	public Card(String name, Integer value) {
		this.name = name;
		this.value = value;
	}
	
	public Integer getValue() {
		return this.value;
	}
	public String toString() {
		return "(" + this.value + ") " + this.name;
	}

	
}
