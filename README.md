# CS310 Team Project 6 - Board Game Implementation

## Overview

This project now includes a board game implementation alongside the original Time and Attendance System (TAS). The board game functionality provides a complete Tic-tac-toe game with a clean object-oriented design.

## Board Game Features

### Classes Added

1. **BoardGame.java** - Abstract base class for all board games
2. **Player.java** - Represents a player with name and symbol
3. **TicTacToe.java** - Complete Tic-tac-toe implementation
4. **GameConsole.java** - Console interface for playing the game
5. **BoardGameDemo.java** - Demonstration of the game functionality

### Tests Added

- **PlayerTest.java** - Tests for Player class functionality
- **TicTacToeTest.java** - Comprehensive tests for game logic including:
  - Game initialization
  - Valid/invalid moves
  - Win conditions (rows, columns, diagonals)
  - Draw conditions
  - Game reset functionality

## How to Play

### Option 1: Interactive Game
Run the main application and select option 2:
```bash
java -cp build edu.jsu.mcis.cs310.tas_sp25.Main
```

### Option 2: Demo Mode
See a demonstration of the game:
```bash
java -cp build edu.jsu.mcis.cs310.tas_sp25.BoardGameDemo
```

## Game Rules

- Tic-tac-toe is played on a 3x3 grid
- Players take turns placing X and O
- First player to get 3 marks in a row (horizontally, vertically, or diagonally) wins
- If all 9 spaces are filled without a winner, the game is a draw

## Building and Testing

### Compile the Board Game Classes
```bash
javac -d build src/edu/jsu/mcis/cs310/tas_sp25/Player.java \
               src/edu/jsu/mcis/cs310/tas_sp25/BoardGame.java \
               src/edu/jsu/mcis/cs310/tas_sp25/TicTacToe.java \
               src/edu/jsu/mcis/cs310/tas_sp25/GameConsole.java \
               src/edu/jsu/mcis/cs310/tas_sp25/BoardGameDemo.java
```

### Run Tests (requires JUnit)
```bash
# Compile tests
javac -cp "build:lib/*" -d build test/edu/jsu/mcis/cs310/tas_sp25/PlayerTest.java \
                                 test/edu/jsu/mcis/cs310/tas_sp25/TicTacToeTest.java

# Run tests
java -cp "build:lib/*" org.junit.runner.JUnitCore edu.jsu.mcis.cs310.tas_sp25.PlayerTest
java -cp "build:lib/*" org.junit.runner.JUnitCore edu.jsu.mcis.cs310.tas_sp25.TicTacToeTest
```

## Architecture

The board game implementation follows object-oriented design principles:

- **Inheritance**: TicTacToe extends BoardGame abstract class
- **Encapsulation**: Private board state with controlled access
- **Polymorphism**: Abstract methods implemented for specific game logic
- **Testability**: Comprehensive unit tests with JUnit

## Future Extensions

The BoardGame abstract class provides a foundation for implementing other board games:
- Chess
- Checkers
- Connect Four
- Othello/Reversi

## Original TAS Functionality

The original Time and Attendance System functionality remains intact and can be accessed through option 1 in the main menu (requires database connectivity).