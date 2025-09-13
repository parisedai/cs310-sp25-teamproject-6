package edu.jsu.mcis.cs310.tas_sp25;

import java.util.Scanner;

/**
 * Console interface for playing board games
 */
public class GameConsole {
    private Scanner scanner;
    
    public GameConsole() {
        scanner = new Scanner(System.in);
    }
    
    public void playTicTacToe() {
        System.out.println("=== Welcome to Tic-Tac-Toe ===");
        
        System.out.print("Enter Player 1 name: ");
        String player1Name = scanner.nextLine().trim();
        if (player1Name.isEmpty()) player1Name = "Player 1";
        
        System.out.print("Enter Player 2 name: ");
        String player2Name = scanner.nextLine().trim();
        if (player2Name.isEmpty()) player2Name = "Player 2";
        
        TicTacToe game = new TicTacToe(player1Name, player2Name);
        
        System.out.println("\n" + player1Name + " will be X, " + player2Name + " will be O");
        
        while (!game.isGameOver()) {
            game.displayBoard();
            
            System.out.println("Current player: " + game.getCurrentPlayer());
            System.out.print("Enter position (1-9): ");
            
            try {
                String input = scanner.nextLine().trim();
                int position = Integer.parseInt(input);
                
                if (game.makeMove(position)) {
                    System.out.println("Move made successfully!");
                } else {
                    System.out.println("Invalid move! Position " + position + " is not available.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number between 1 and 9.");
            }
        }
        
        game.displayBoard();
        
        if (game.getWinner() != null) {
            System.out.println("🎉 Congratulations! " + game.getWinner().getName() + " wins!");
        } else {
            System.out.println("It's a draw! Good game!");
        }
        
        System.out.print("Play again? (y/n): ");
        String playAgain = scanner.nextLine().trim().toLowerCase();
        if (playAgain.equals("y") || playAgain.equals("yes")) {
            playTicTacToe();
        } else {
            System.out.println("Thanks for playing!");
        }
    }
    
    public void close() {
        scanner.close();
    }
}