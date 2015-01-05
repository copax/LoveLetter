package com.copac.loveletter;

import java.util.ArrayList;

import com.copac.cardgame.exception.DeckEmptyException;

public class Main {

	public static void main(String[] args) {		
		LoveLetterDeck deck = new LoveLetterDeck();
		deck.shuffle();
		
		ArrayList<LoveLetterPlayer> players = new ArrayList<LoveLetterPlayer>();
		
		for(int i=1; i<=4; i++)
			try {
				players.add(new LoveLetterPlayer(i, deck));
			} catch (DeckEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		System.out.println("Game Start");
		for(LoveLetterPlayer player : players) {
			System.out.println(player.toString());
		}
		System.out.println("\nDeck State: " + deck.toString());
		System.out.println("---------------------------\n");
		
		
		int count=1;
		while(deck.notEmpty()) {
			System.out.println("Round #" + count++);
			for(LoveLetterPlayer player : players) {
				if(deck.notEmpty()) {
					System.out.println("Player # " + player.seat + " taking their turn.");
					if(!player.outOfGame) {
						try {
							System.out.println("Player # " + player.seat + " drawing a card.");
						player.draw(deck);
						System.out.println("Player # " + player.seat + " playing a card");
						player.playCard(deck,players);
						} catch (DeckEmptyException e) {
							System.out.println("DECK EMPTY");
							continue;
						}
					} else {
						System.out.println("Player # " + player.seat + " is out of the game.");
					}
			}
			
			Integer activePlayerCount = 0;
			for(LoveLetterPlayer player1 : players) {
				System.out.println(player1.toString());
				if(!player1.outOfGame) {
					activePlayerCount++;
				}
				player1.setHandmaid(false);
			}
			System.out.println("\nDeck State: \n" + deck.toString());
			System.out.println("---------------------------\n");
			if(activePlayerCount == 1) {
				break;
			}
			
		}
	if(!deck.notEmpty()) {
		System.out.println("DECK EMPTY");
	}
		
		
	}


	}
	}
