package edu.jsu.mcis.cs310.tas_sp25;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
    
    private TicTacToe game;
    
    @Before
    public void setup() {
        game = new TicTacToe("Alice", "Bob");
    }
    
    @Test
    public void testGameInitialization() {
        assertFalse(game.isGameOver());
        assertNull(game.getWinner());
        assertEquals("Alice", game.getCurrentPlayer().getName());
        assertEquals('X', game.getCurrentPlayer().getSymbol());
    }
    
    @Test
    public void testValidMove() {
        assertTrue(game.makeMove(5)); // Center position
        assertEquals('X', game.getBoardCell(1, 1));
        assertEquals("Bob", game.getCurrentPlayer().getName());
    }
    
    @Test
    public void testInvalidMove() {
        game.makeMove(5); // Alice takes center
        assertFalse(game.makeMove(5)); // Bob tries to take same position
        assertEquals("Bob", game.getCurrentPlayer().getName()); // Still Bob's turn
    }
    
    @Test
    public void testIsValidMove() {
        assertTrue(game.isValidMove(1));
        assertTrue(game.isValidMove(9));
        assertFalse(game.isValidMove(0)); // Invalid position
        assertFalse(game.isValidMove(10)); // Invalid position
        
        game.makeMove(5);
        assertFalse(game.isValidMove(5)); // Position already taken
    }
    
    @Test
    public void testWinByRow() {
        // Alice wins with top row
        game.makeMove(1); // Alice: X
        game.makeMove(4); // Bob: O
        game.makeMove(2); // Alice: X
        game.makeMove(5); // Bob: O
        game.makeMove(3); // Alice: X - wins!
        
        assertTrue(game.isGameOver());
        assertEquals("Alice", game.getWinner().getName());
    }
    
    @Test
    public void testWinByColumn() {
        // Bob wins with middle column
        game.makeMove(1); // Alice: X
        game.makeMove(2); // Bob: O
        game.makeMove(3); // Alice: X
        game.makeMove(5); // Bob: O
        game.makeMove(7); // Alice: X
        game.makeMove(8); // Bob: O - wins!
        
        assertTrue(game.isGameOver());
        assertEquals("Bob", game.getWinner().getName());
    }
    
    @Test
    public void testWinByDiagonal() {
        // Alice wins with diagonal
        game.makeMove(1); // Alice: X
        game.makeMove(2); // Bob: O
        game.makeMove(5); // Alice: X
        game.makeMove(3); // Bob: O
        game.makeMove(9); // Alice: X - wins!
        
        assertTrue(game.isGameOver());
        assertEquals("Alice", game.getWinner().getName());
    }
    
    @Test
    public void testDraw() {
        // Create a draw scenario
        game.makeMove(1); // Alice: X
        game.makeMove(2); // Bob: O
        game.makeMove(3); // Alice: X
        game.makeMove(5); // Bob: O
        game.makeMove(4); // Alice: X
        game.makeMove(6); // Bob: O
        game.makeMove(8); // Alice: X
        game.makeMove(7); // Bob: O
        game.makeMove(9); // Alice: X
        
        assertTrue(game.isGameOver());
        assertNull(game.getWinner()); // Draw
    }
    
    @Test
    public void testSwitchPlayer() {
        assertEquals("Alice", game.getCurrentPlayer().getName());
        game.makeMove(1);
        assertEquals("Bob", game.getCurrentPlayer().getName());
        game.makeMove(2);
        assertEquals("Alice", game.getCurrentPlayer().getName());
    }
    
    @Test
    public void testResetGame() {
        game.makeMove(1);
        game.makeMove(2);
        game.makeMove(3);
        
        game.resetGame();
        
        assertFalse(game.isGameOver());
        assertNull(game.getWinner());
        assertEquals("Alice", game.getCurrentPlayer().getName());
        assertEquals(' ', game.getBoardCell(0, 0));
        assertEquals(' ', game.getBoardCell(0, 1));
        assertEquals(' ', game.getBoardCell(0, 2));
    }
    
    @Test
    public void testGetBoard() {
        game.makeMove(1); // Position 1
        game.makeMove(5); // Position 5
        
        char[][] board = game.getBoard();
        assertEquals('X', board[0][0]); // Position 1
        assertEquals('O', board[1][1]); // Position 5
        
        // Test that it's a copy (modifying it doesn't affect the game)
        board[0][1] = 'Z';
        assertEquals(' ', game.getBoardCell(0, 1));
    }
    
    @Test
    public void testNoMovesAfterGameOver() {
        // Alice wins
        game.makeMove(1); // Alice: X
        game.makeMove(4); // Bob: O
        game.makeMove(2); // Alice: X
        game.makeMove(5); // Bob: O
        game.makeMove(3); // Alice: X - wins!
        
        assertTrue(game.isGameOver());
        
        // No more moves should be allowed
        assertFalse(game.makeMove(6));
        assertFalse(game.makeMove(7));
    }
}