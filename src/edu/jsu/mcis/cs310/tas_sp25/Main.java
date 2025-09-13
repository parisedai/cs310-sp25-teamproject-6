package edu.jsu.mcis.cs310.tas_sp25;

import edu.jsu.mcis.cs310.tas_sp25.dao.*;
import java.time.*;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class Main {
    // Michael Frix

    public static void main(String[] args) {
        
        System.out.println("=== CS310 Team Project 6 ===");
        System.out.println("Choose an option:");
        System.out.println("1. Test Database Connectivity (original functionality)");
        System.out.println("2. Play Tic-Tac-Toe Board Game");
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice (1 or 2): ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    testDatabaseConnectivity();
                    break;
                case 2:
                    playBoardGame();
                    break;
                default:
                    System.out.println("Invalid choice. Playing board game by default.");
                    playBoardGame();
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error reading input. Playing board game by default.");
            playBoardGame();
        } finally {
            scanner.close();
        }
    }
    
    private static void testDatabaseConnectivity() {
        try {
            // test database connectivity; get DAO
            DAOFactory daoFactory = new DAOFactory("tas.jdbc");
            BadgeDAO badgeDAO = daoFactory.getBadgeDAO();
            
            // find badge
            Badge b = badgeDAO.find("C4F37EFF");
            
            // output should be "Test Badge: #C4F37EFF (Welch, Travis C)"
            System.err.println("Test Badge: " + b.toString());
        } catch (Exception e) {
            System.err.println("Database connectivity test failed: " + e.getMessage());
            System.err.println("This is expected if database is not available.");
        }
    }
    
    private static void playBoardGame() {
        GameConsole console = new GameConsole();
        console.playTicTacToe();
        console.close();
    }

}
