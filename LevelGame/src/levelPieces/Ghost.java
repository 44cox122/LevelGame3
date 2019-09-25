package levelPieces;
import gameEngine.GameEngine;
import java.util.Random;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

//Ghost is one of the hit pieces
public class Ghost extends GamePiece implements Moveable {
	private Random rand = new Random();
	private char symbol;
	private int location;
	private int oldLocation;
	private int newLocation;
	
	public Ghost(char symbol, int location) {
		//Constructor
		super(symbol, location);
		this.symbol = symbol;
		this.location = location;
	}
	

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		//Telling what interaction to do
		if(playerLocation == this.newLocation) {return InteractionResult.HIT;}
		else {return InteractionResult.NONE;}
		
	}

	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		if(this.location > 12) {
			oldLocation = this.location;
			// Warrior in random locations before the door so it makes it slightly harder to pass
			newLocation = rand.nextInt(7) + 13; 
			this.location = newLocation;
			Ghost newGhost = new Ghost('G', oldLocation);
			newGhost.location = newLocation;
			gameBoard[oldLocation] = null;
			gameBoard[newLocation] = newGhost;
		}
	}
	
	
	public void draw() {
		//Draws the given char
		System.out.print(this.symbol);
	}

	
}
