package com.copac.loveletter;

import java.util.ArrayList;

public class Player {
	private Hand hand;
	public Tableau tableau;
	public Integer seat;
	Boolean outOfGame;
	
	public Player(Integer num, Deck d) {
		seat = num;
		hand = new Hand();
		tableau = new Tableau();
		outOfGame = false;
		draw(d);
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void lose() {
		tableau.addCard(hand.removeCard(0));
		outOfGame = true;
	}
	
	public void draw(Deck deck) {
		hand.addCard(deck.drawCard());
	}
	
	public void playCard(Deck deck, ArrayList<Player> players) {
		int pos = 0;
		if(hand.cards.get(0).value > hand.cards.get(1).value)
			pos = 0;
		else 
			pos = 1;
		
		Card cardToPlay = hand.cards.get(pos);
		tableau.addCard(hand.removeCard(pos));
		switch(cardToPlay.value) {
		case 1:
			//Guard
			break;
		case 2:
			//Priest
			break;
		case 3:
			//Baron
			int targetSeat = (this.seat % 4);
			Player targetPlayer = players.get(targetSeat);
			while(targetPlayer.outOfGame) {
				targetSeat = (targetSeat++ % 4);
				targetPlayer = players.get(targetSeat);
			}
			if(this.getHand().getCard(0).getValue() > targetPlayer.getHand().getCard(0).getValue()) {
				targetPlayer.lose();
			} else if(this.getHand().getCard(0).getValue() < targetPlayer.getHand().getCard(0).getValue()) {
				this.lose();
			}
			break;
		case 4:
			//Handmaid
			break;
		case 5:
			//Prince
			break;
		case 6:
			//King
			break;
		case 7:
			//Countess
			break;
		case 8:
			//Princess
			break;
		}
		
	}
	
	public String toString() {
		StringBuilder tmp = new StringBuilder();
		tmp.append("Player #" + seat + (outOfGame ? "(OUT)" : "") + "\n");
		
		tmp.append("Hand: \n" + hand.toString() + "\n");
		tmp.append("Tableau: \n" + tableau.toString() + "\n");
		return tmp.toString();
	}
}
