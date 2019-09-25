package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;


//Treasure is our get point piece
public class Treasure extends GamePiece  implements Moveable {
	private char symbol;
	private int location;
	
	
	public Treasure(char symbol, int location) {
		//Constructor
		super(symbol, location);
		this.symbol = symbol;
		this.location = location;
	}

	public int getLocation() {
		return this.location;
	}
	
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//Decreases the location of the piece by 1 each time it moves then resets it to 6 once it goes past 0
		int oldLocation = this.location;
		this.location--;
		int newLocation = this.location; 		
		if(newLocation<=0) {newLocation = 6;}
		Treasure newTreasure = new Treasure('T', newLocation);
		this.location = newLocation;
		gameBoard[oldLocation] = null;
		gameBoard[newLocation] = newTreasure;
	}
	
	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		//Telling what interaction to do
		if((playerLocation + 1) == this.location) {return InteractionResult.GET_POINT;}
		else {return InteractionResult.NONE;}
	}
	
	
	public void draw() {
		//Draws the given char
		System.out.print(this.symbol);
	}
	
	
}
