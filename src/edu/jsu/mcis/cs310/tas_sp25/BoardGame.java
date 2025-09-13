package edu.jsu.mcis.cs310.tas_sp25;

/**
 * Abstract base class for board games
 * Provides common functionality for all board games
 */
public abstract class BoardGame {
    protected Player currentPlayer;
    protected Player player1;
    protected Player player2;
    protected boolean gameOver;
    protected Player winner;
    
    public BoardGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 'X');
        this.player2 = new Player(player2Name, 'O');
        this.currentPlayer = player1;
        this.gameOver = false;
        this.winner = null;
    }
    
    public abstract boolean makeMove(int position);
    public abstract boolean isValidMove(int position);
    public abstract boolean checkWin();
    public abstract boolean checkDraw();
    public abstract void displayBoard();
    public abstract void resetGame();
    
    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Player getWinner() {
        return winner;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    
    public Player getPlayer2() {
        return player2;
    }
}