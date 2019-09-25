package levelPieces;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

//Door is our advance piece
public class Door extends GamePiece implements Drawable{

	public Door() {
		//Constructor
		super('D', GameEngine.BOARD_SIZE - 1);
	}
	
	public Door(char symbol, int location) {
		//Constructor
		super(symbol, location);
	}

	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		//Telling what interaction to do
		if(playerLocation == super.getLocation()) {return InteractionResult.ADVANCE;}
		else {return InteractionResult.NONE;}
	}
	
	
	public void draw() {
		//Draws the given char
		System.out.print("D");
	}
	
	
}
