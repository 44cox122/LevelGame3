package gameEngine;

import java.util.ArrayList;
import gameEngine.GameEngine;
import levelPieces.Door;
import levelPieces.GamePiece;
import levelPieces.Nuke;
import levelPieces.Rock;
import levelPieces.Treasure;
import levelPieces.Ghost;
import levelPieces.Warrior;


public class LevelEngine {
	public Drawable[] myGameBoard = new Drawable[GameEngine.BOARD_SIZE];
	//Our global variables
	private ArrayList<Moveable> myMoveable = new ArrayList<Moveable>();
	private ArrayList<GamePiece> myInteracting = new ArrayList<GamePiece>();
	int myLevel;

	
	public LevelEngine() {
		super();
	}
	

	public void createLevel(int levelNum) {
		//level variable
		myLevel = levelNum;	
		
		//creates level 1
		if(myLevel == 1) {
			Ghost p1 = new Ghost('G', 15);
			Door p2 = new Door();
			Treasure p3 = new Treasure('T', 6);
			Rock p4 = new Rock();
			Warrior p6 = new Warrior('W',8);
			
			// Add pieces
			myGameBoard[p1.getLocation()] = p1;
			myGameBoard[p2.getLocation()] = p2;
			myGameBoard[p3.getLocation()] = p3;
			myGameBoard[p6.getLocation()] = p6;
			myGameBoard[12] = p4;	
			
			// Add interacting 
			this.myInteracting.add(p1);
			this.myInteracting.add(p2);
			this.myInteracting.add(p3);
			this.myInteracting.add(p6);
			
			// Add moveable
			this.myMoveable.add(p1);
			this.myMoveable.add(p3);
			
		//creates level 2
		}else if(myLevel == 2) {
			for(int i = 0; i < myGameBoard.length; i++) {myGameBoard[i] = null;}	
			myInteracting.clear();	
			myMoveable.clear();
			
			// No ghost on this level!!
			Door p2 = new Door();
			Treasure p3 = new Treasure('T', 6);
			Rock p4 = new Rock();
			Nuke p5 = new Nuke();
			
			for(int i = (myGameBoard.length/2 + 3); i < myGameBoard.length - 2; i += 2) {		// This makes the last half of the board filled with rocks and warriors...will the player survive?
				Warrior p6 = new Warrior('W',i);
				myGameBoard[i - 1] = p4;
				this.myInteracting.add(p6);
				myGameBoard[p6.getLocation()] = p6;
			}
			
			// Add other pieces
			myGameBoard[p2.getLocation()] = p2;
			myGameBoard[p3.getLocation()] = p3;
			myGameBoard[p5.getLocation()] = p5;
			
			// Add interacting
			this.myInteracting.add(p2);
			this.myInteracting.add(p3);
			this.myInteracting.add(p5);
			
			// Add moveable
			this.myMoveable.add(p3);
		}
	}
	
	//Board getter
	public Drawable[] getBoard() {
		return myGameBoard;
	}

	//Moveable getter
	public ArrayList<Moveable> getMovingPieces() {
		return this.myMoveable;
	}

	//Interacting getter
	public ArrayList<GamePiece> getInteractingPieces() {
		return this.myInteracting;
	}

	
	public int getPlayerStartLoc() {
		return 0;
	}

}
