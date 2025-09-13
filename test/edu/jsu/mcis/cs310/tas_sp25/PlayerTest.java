package edu.jsu.mcis.cs310.tas_sp25;

import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest {
    
    @Test
    public void testPlayerCreation() {
        Player player = new Player("Alice", 'X');
        
        assertEquals("Alice", player.getName());
        assertEquals('X', player.getSymbol());
    }
    
    @Test
    public void testPlayerToString() {
        Player player1 = new Player("Bob", 'O');
        Player player2 = new Player("Charlie", 'X');
        
        assertEquals("Bob (O)", player1.toString());
        assertEquals("Charlie (X)", player2.toString());
    }
    
    @Test
    public void testPlayerEquals() {
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Alice", 'X');
        Player player3 = new Player("Bob", 'X');
        Player player4 = new Player("Alice", 'O');
        
        assertEquals(player1, player2);
        assertNotEquals(player1, player3);
        assertNotEquals(player1, player4);
        assertNotEquals(player1, null);
        assertNotEquals(player1, "not a player");
    }
    
    @Test
    public void testPlayerHashCode() {
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Alice", 'X');
        
        assertEquals(player1.hashCode(), player2.hashCode());
    }
}