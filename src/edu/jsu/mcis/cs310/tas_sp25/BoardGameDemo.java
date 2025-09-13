package edu.jsu.mcis.cs310.tas_sp25;

/**
 * Simple demonstration of the board game functionality
 * This class demonstrates the board game without requiring database connectivity
 */
public class BoardGameDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Board Game Demo ===");
        System.out.println("This demo shows the board game functionality without requiring database connectivity.\n");
        
        // Create a game
        TicTacToe game = new TicTacToe("Alice", "Bob");
        
        System.out.println("Created a new Tic-Tac-Toe game with players:");
        System.out.println("Player 1: " + game.getPlayer1());
        System.out.println("Player 2: " + game.getPlayer2());
        System.out.println("Current player: " + game.getCurrentPlayer());
        
        // Show initial board
        game.displayBoard();
        
        // Demonstrate some moves
        System.out.println("=== Demonstration Game ===");
        System.out.println("Making moves: 5, 1, 6, 2, 4");
        
        game.makeMove(5); // Alice (X) takes center
        System.out.println("Alice played position 5:");
        game.displayBoard();
        
        game.makeMove(1); // Bob (O) takes top-left
        System.out.println("Bob played position 1:");
        game.displayBoard();
        
        game.makeMove(6); // Alice (X) takes middle-right
        System.out.println("Alice played position 6:");
        game.displayBoard();
        
        game.makeMove(2); // Bob (O) takes top-center
        System.out.println("Bob played position 2:");
        game.displayBoard();
        
        game.makeMove(4); // Alice (X) takes middle-left -> Alice wins!
        System.out.println("Alice played position 4:");
        game.displayBoard();
        
        if (game.isGameOver()) {
            if (game.getWinner() != null) {
                System.out.println("🎉 " + game.getWinner().getName() + " wins!");
            } else {
                System.out.println("It's a draw!");
            }
        }
        
        System.out.println("\n=== Board Game Demo Complete ===");
        System.out.println("To play interactively, run Main.java and select option 2.");
    }
}