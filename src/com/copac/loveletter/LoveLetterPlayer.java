package com.copac.loveletter;

import java.util.ArrayList;

import com.copac.cardgame.exception.DeckEmptyException;
import com.copac.cardgame.*;

public class LoveLetterPlayer extends Player{
	private Boolean handmaid; 
	
	public LoveLetterPlayer(Integer num, Deck d) throws DeckEmptyException {
		super(num, d);
		handmaid = false;
	}
	
	public void setHandmaid(Boolean val) {
		handmaid = val;
	}


	public Boolean protectedByHandmaid() {
		return handmaid;
	}
	public void playCard(LoveLetterDeck deck, ArrayList<LoveLetterPlayer> players) {
		int pos = 0;
		if(hand.cards.get(0).getValue() > hand.cards.get(1).getValue())
			pos = 0;
		else 
			pos = 1;
		
		Card cardToPlay = hand.cards.get(pos);
		System.out.println("Card played: " + cardToPlay);
		tableau.addCard(hand.removeCard(pos));
		switch(cardToPlay.getValue()) {
		case 1:
			//Guard
			break;
		case 2:
			//Priest
			break;
		case 3:
			//Baron
			int targetSeat = (this.seat % players.size());
			LoveLetterPlayer targetPlayer = players.get(targetSeat);
			while(targetPlayer.outOfGame || targetPlayer.protectedByHandmaid()) {
				targetSeat++;
				targetSeat = (targetSeat % players.size());
				targetPlayer = players.get(targetSeat);
				System.out.println("Seat: " + targetSeat + " OutOfGame: " + targetPlayer.outOfGame + " Handmaid: " + targetPlayer.protectedByHandmaid());
			}
			if(this.getHand().getCard(0).getValue() > targetPlayer.getHand().getCard(0).getValue()) {
				targetPlayer.lose();
			} else if(this.getHand().getCard(0).getValue() < targetPlayer.getHand().getCard(0).getValue()) {
				this.lose();
			}
			break;
		case 4:
			//Handmaid
			this.setHandmaid(true);
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
		tmp.append("Player #" + seat + (outOfGame ? "(OUT)" : "") + (handmaid ? "(HANDMAID)" : "") + "\n");
		
		tmp.append("Hand: \n" + hand.toString() + "\n");
		tmp.append("Tableau: \n" + tableau.toString() + "\n");
		return tmp.toString();
	}

}
