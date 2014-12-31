package com.copac.loveletter;

public class DeckEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3605263313649351963L;

	public DeckEmptyException(){
        super();
    }

    public DeckEmptyException(String message){
        super(message);
    }
}
