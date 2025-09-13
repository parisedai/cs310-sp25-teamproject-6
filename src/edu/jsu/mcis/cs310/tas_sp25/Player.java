package edu.jsu.mcis.cs310.tas_sp25;

/**
 * Represents a player in a board game
 */
public class Player {
    private String name;
    private char symbol;
    
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    
    public String getName() {
        return name;
    }
    
    public char getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return symbol == player.symbol && name.equals(player.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode() + Character.hashCode(symbol);
    }
}