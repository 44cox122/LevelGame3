package tests;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import junit.framework.TestCase;
import levelPieces.Ghost;
import levelPieces.Treasure;

public class TestMovingPieces extends TestCase {
	
	@Test
	public void testTreasureMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Treasure my_treasure = new Treasure('T',6);
		for(int i = 6; i <= 0; i--) {
			my_treasure.move(gameBoard, 15);
			if(my_treasure.getLocation() != i) {fail("location is not where expected." + my_treasure.getLocation());}
		}
		
		
	}
	@Test
	public void testRandomMovement() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ghost my_ghost = new Ghost('G',15);
		for(int i = 0; i<200;i++) {
			my_ghost.move(gameBoard, 5);
			if(my_ghost.getLocation() < 13 || my_ghost.getLocation() > 20) {
				fail("invalid move");
			}
		}
		
	}
}
