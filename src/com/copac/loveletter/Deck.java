package com.copac.loveletter;

import java.util.ArrayList;
import java.util.Collections;

import com.copac.loveletter.cards.Baron;
import com.copac.loveletter.cards.Countess;
import com.copac.loveletter.cards.Guard;
import com.copac.loveletter.cards.Handmaid;
import com.copac.loveletter.cards.King;
import com.copac.loveletter.cards.Priest;
import com.copac.loveletter.cards.Prince;
import com.copac.loveletter.cards.Princess;

public class Deck {
	public ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
		for(int i=0; i<5; i++)
			cards.add(new Guard());
		for(int i=0; i<2; i++) {
			cards.add(new Priest());
			cards.add(new Baron());
			cards.add(new Handmaid());
			cards.add(new Prince());
		}
		cards.add(new King());
		cards.add(new Countess());
		cards.add(new Princess());
	
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card drawCard() throws DeckEmptyException {
		if(cards.isEmpty())
			throw new DeckEmptyException();
		Card c = cards.get(0);
		cards.remove(0);
		return c;
	}
	
	public Integer remainingCards() {
		return cards.size();
	}
	
	public Boolean notEmpty() {
		return (!cards.isEmpty());
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
