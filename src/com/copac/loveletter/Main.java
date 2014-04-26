package com.copac.loveletter;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {		
		Deck deck = new Deck();
		deck.shuffle();
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for(int i=1; i<=4; i++)
			players.add(new Player(i, deck));
		
		
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
				if(!player.outOfGame) {
					player.draw(deck);
					player.playCard(deck,players);
				}
			}
			
			for(Player player : players) {
				System.out.println(player.toString());
			}
			System.out.println("\nDeck State: " + deck.toString());
			System.out.println("---------------------------\n");
		}
		
		
	}


}
