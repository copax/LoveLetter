package com.copac.loveletter;

import java.util.ArrayList;



public class Hand {
	public ArrayList<Card> cards; 
	
	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card c) {
		cards.add(c);
	}
	
	public Card removeCard(int pos) {
		Card tmp = cards.get(pos);
		cards.remove(pos);
		return tmp;
	}
	
	public Card getCard(int pos) {
		return cards.get(pos);
	}
	
	public String toString() {
		StringBuilder tmp = new StringBuilder();
		int count = 1;
		for(Card c : cards) {
			tmp.append("Card #" + count++ + " - " + c.toString() + "\n");
		}
		return tmp.toString();
	}
}
