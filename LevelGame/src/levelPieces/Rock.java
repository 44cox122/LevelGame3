package levelPieces;
import gameEngine.Drawable;

//Rock is our non-interactable piece
public class Rock implements Drawable{

	public Rock() {
		//Constructor
		super();
	}
	

	@Override
	public void draw() {
		//Draws the given char
		System.out.print("R");
	}

	
}
