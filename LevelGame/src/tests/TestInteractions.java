package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Door;
import levelPieces.Ghost;
import levelPieces.Nuke;
import levelPieces.Treasure;
import levelPieces.Warrior;

public class TestInteractions {

	@Test
	public void testDoor() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Door my_Door = new Door('D', 6);
		gameBoard[6] = my_Door;
		
		// Hits player if they are on the same space
		assertEquals(InteractionResult.ADVANCE, my_Door.interact(gameBoard, 6));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<6; i++)
			assertEquals(InteractionResult.NONE, my_Door.interact(gameBoard, i));
		for (int i=7; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, my_Door.interact(gameBoard, i));
	}		
	
	
	@Test
	public void testWarrior() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Warrior my_warrior= new Warrior('W', 6);
		gameBoard[6] = my_warrior;
		
		// Hits player if they are on the same space
		assertEquals(InteractionResult.HIT, my_warrior.interact(gameBoard, 6));
		// These loops ensure no interaction if not on same space
		for (int i=0; i<6; i++)
			assertEquals(InteractionResult.NONE, my_warrior.interact(gameBoard, i));
		for (int i=7; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, my_warrior.interact(gameBoard, i));
	}	
	
	
	@Test
	public void testNuke() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Nuke my_nuke = new Nuke();
		gameBoard[8] = my_nuke;
		
		// Hits player if they are on the same space
		assertEquals(InteractionResult.NUKED, my_nuke.interact(gameBoard, 8));
	}	
	
	
	@Test
	public void testTreasure() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Treasure my_treasure = new Treasure('T', 6);
		gameBoard[6] = my_treasure;
		
		// Hits player if they are on the same space, special because they move towards eachother in this case
		assertEquals(InteractionResult.GET_POINT, my_treasure.interact(gameBoard, 5));
		
	}
	
	
	@Test
	public void testGhost() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ghost my_ghost = new Ghost('G', 6);
		gameBoard[6] = my_ghost;
		assertEquals(InteractionResult.HIT, my_ghost.interact(gameBoard, 0));
		 //These loops ensure no interaction if not on same space
		for (int i=1; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, my_ghost.interact(gameBoard, i));
}	

}
