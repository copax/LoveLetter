package com.copac.loveletter;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {		
		Deck deck = new Deck();
		deck.shuffle();
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for(int i=1; i<=4; i++)
			try {
				players.add(new Player(i, deck));
			} catch (DeckEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		System.out.println("Game Start");
		for(Player player : players) {
			System.out.println(player.toString());
		}
		System.out.println("\nDeck State: " + deck.toString());
		System.out.println("---------------------------\n");
		
		
		int count=1;
		while(deck.notEmpty()) {
			System.out.println("Round #" + count++);
			for(Player player : players) {
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
			
			for(Player player1 : players) {
				System.out.println(player1.toString());
			}
			System.out.println("\nDeck State: " + deck.toString());
			System.out.println("---------------------------\n");
		}
		
		
	}


	}
	}
