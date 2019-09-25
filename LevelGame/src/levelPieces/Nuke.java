package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

//Nuke is a instant kill piece
public class Nuke extends GamePiece implements Drawable{

	public Nuke() {
		//Constructor
		super('N', 8);
	}

	
	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		//Telling what interaction to do. This is also our ranged piece
		if(super.getLocation() >= playerLocation - 2 && super.getLocation() <= playerLocation + 2 ) {return InteractionResult.NUKED;}
		else {return InteractionResult.NONE;}
	}
	
	
	public void draw() {
		//Draws the given char
		System.out.print("N");
	}

	
}
