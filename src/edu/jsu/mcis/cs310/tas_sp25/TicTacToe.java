package edu.jsu.mcis.cs310.tas_sp25;

/**
 * Implementation of Tic-tac-toe board game
 * A 3x3 grid where players take turns placing X and O
 */
public class TicTacToe extends BoardGame {
    private char[][] board;
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY = ' ';
    
    public TicTacToe(String player1Name, String player2Name) {
        super(player1Name, player2Name);
        board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
    
    @Override
    public boolean makeMove(int position) {
        if (!isValidMove(position)) {
            return false;
        }
        
        int row = (position - 1) / BOARD_SIZE;
        int col = (position - 1) % BOARD_SIZE;
        
        board[row][col] = currentPlayer.getSymbol();
        
        if (checkWin()) {
            gameOver = true;
            winner = currentPlayer;
        } else if (checkDraw()) {
            gameOver = true;
            winner = null; // Draw
        } else {
            switchPlayer();
        }
        
        return true;
    }
    
    @Override
    public boolean isValidMove(int position) {
        if (position < 1 || position > 9 || gameOver) {
            return false;
        }
        
        int row = (position - 1) / BOARD_SIZE;
        int col = (position - 1) % BOARD_SIZE;
        
        return board[row][col] == EMPTY;
    }
    
    @Override
    public boolean checkWin() {
        char symbol = currentPlayer.getSymbol();
        
        // Check rows
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        
        // Check columns
        for (int j = 0; j < BOARD_SIZE; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean checkDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public void displayBoard() {
        System.out.println("\n Current Board:");
        System.out.println(" " + getCellDisplay(0, 0) + " | " + getCellDisplay(0, 1) + " | " + getCellDisplay(0, 2));
        System.out.println("-----------");
        System.out.println(" " + getCellDisplay(1, 0) + " | " + getCellDisplay(1, 1) + " | " + getCellDisplay(1, 2));
        System.out.println("-----------");
        System.out.println(" " + getCellDisplay(2, 0) + " | " + getCellDisplay(2, 1) + " | " + getCellDisplay(2, 2));
        System.out.println();
        
        System.out.println("Positions:");
        System.out.println(" 1 | 2 | 3");
        System.out.println("-----------");
        System.out.println(" 4 | 5 | 6");
        System.out.println("-----------");
        System.out.println(" 7 | 8 | 9");
        System.out.println();
    }
    
    private String getCellDisplay(int row, int col) {
        char cell = board[row][col];
        return (cell == EMPTY) ? " " : String.valueOf(cell);
    }
    
    @Override
    public void resetGame() {
        initializeBoard();
        currentPlayer = player1;
        gameOver = false;
        winner = null;
    }
    
    public char[][] getBoard() {
        // Return a copy to prevent external modification
        char[][] copy = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
    
    public char getBoardCell(int row, int col) {
        if (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE) {
            return board[row][col];
        }
        return EMPTY;
    }
}