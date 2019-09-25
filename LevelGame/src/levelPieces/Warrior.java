package levelPieces;
import gameEngine.GameEngine;
import java.util.Random;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

//Warrior is one of the hit pieces
public class Warrior extends GamePiece implements Drawable {
	private char symbol;
	private int location;

	
	public Warrior(char symbol, int location) {
		//Constructor
		super(symbol, location);
		this.symbol = symbol;
		this.location = location;
	}
	

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		//Telling what interaction to do
		if(playerLocation == this.location) {return InteractionResult.HIT;}
		else {return InteractionResult.NONE;}		
	}


	public void draw() {
		//Draws the given char
		System.out.print(this.symbol);
	}

	
}
