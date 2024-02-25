
// import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;
import java.util.Scanner;
// import org.junit.jupiter.api.Test;

public class Main {
  static char[][] locations = new char[][] { { '1', '2', '3' },
      { '4', '5', '6' },
      { '7', '8', '9' } };
  static boolean winner = false;

  public static void main(String[] args) {
    System.out.println("Welcome to Tic-Tac-Toe!");
    promptGameMode();

  }

  public static void promptGameMode() {
    System.out.println("<> 1 for single player");
    System.out.println("<> 2 for multiplayer");
    System.out.println("<> 3 for game rules");
    System.out.println("<> 4 to exit");
    System.out.println("Enter your choice: ");
    Scanner scanner = new Scanner(System.in);
    int gameMode = scanner.nextInt();
    scanner.nextLine();
    if (gameMode == 1) {// single player
      System.out.println("\nYou chose single player\nStarting Game\n");
      singlePlayerEngine();
    } else if (gameMode == 2) {// multiplayer
      System.out.println("\nYou chose multiplayer\nStarting Game\n");
      multiplayerEngine();
    } else if (gameMode == 3) {// game rules
      System.out.println("\nTic-Tac-Toe Game Rules:");
      System.out.println("<> Pick a number 1-9 to place your X or O on the board.");
      System.out.println("<> Pick 0 to quit the game");
      System.out.println("<> Match 3 in a row to win the game.");
      System.out.println("\nPress ENTER to go back to main menu: ");
      scanner.nextLine();
      promptGameMode();
    } else if (gameMode == 4) {// exit game
      System.out.println("\nThanks for playing!");
      return;
    } else {// wrong input
      // prompt user again
      System.out.println("You choose an invalid option. Please try again.\n");
      promptGameMode();
    }
  }

  // for multiplayer games with 2 players
  public static void multiplayerEngine() {
    int numMoves = 0; // if this reaches 9 and no winner = false, then it's a tie
    Scanner sc = new Scanner(System.in);
    printBoard(locations);
    while (true) {
      // prompt player 1
      boolean repeat = false;
      System.out.println("Player 1 turn. Pick a location or 0 to quit: ");
      int player1 = sc.nextInt();
      if (player1 < 0 || player1 > 9) {
        repeat = true;
      } else {
        repeat = false;
      }
      while (repeat) {
        System.out.println("Invalid input. Please try again.");
        player1 = sc.nextInt();
        if (player1 < 0 || player1 > 9) {
          repeat = true;
        } else {
          repeat = false;
        }
      }
      if (player1 == 0) {
        System.out.println("Exiting Game");
        break;
      }
      player1Move(player1, sc);
      numMoves++;
      if (winner) {
        winner = false;
        numMoves = 0;
        break;
      }
      if (numMoves == 9) {
        System.out.println("It's a tie!\n");
        numMoves = 0;
        break;
      }

      // prompt player 2
      System.out.println("Player 2 turn. Pick a location or 0 to quit: ");
      int player2 = sc.nextInt();
      if (player2 < 0 || player2 > 9) {
        repeat = true;
      } else {
        repeat = false;
      }
      while (repeat) {
        System.out.println("Invalid input. Please try again.");
        player1 = sc.nextInt();
        if (player2 < 0 || player2 > 9) {
          repeat = true;
        } else {
          repeat = false;
        }
      }
      // add X to the location on board and print board and check if player 1 wins
      if (player2 == 0) {
        System.out.println("Exiting Game");
        break;
      }
      player2Move(player2, sc);
      numMoves++;
      if (winner) {
        numMoves = 0;
        winner = false;
        break;
      }
      if (numMoves == 9) {
        System.out.println("----- It's a tie! -----\n\n");
        numMoves = 0;
        break;
      }
    }
    // reset the board
    resetBoard();
    promptGameMode();
  }

  // for multiplayer: prompts player1 to enter input and checks if input is valid
  public static void player1Move(int player1, Scanner sc) {
    // add X to the location on board and print board and check if player 1 wins
    if (player1 == 1) {
      if (!locationIsTaken(0, 0)) {
        locations[0][0] = 'X';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player1 = sc.nextInt();
        player1Move(player1, sc);
      }
    } else if (player1 == 2) {
      if (!locationIsTaken(0, 1)) {
        locations[0][1] = 'X';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player1 = sc.nextInt();
        player1Move(player1, sc);
      }
    } else if (player1 == 3) {
      if (!locationIsTaken(0, 2)) {
        locations[0][2] = 'X';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player1 = sc.nextInt();
        player1Move(player1, sc);
      }
    } else if (player1 == 4) {
      if (!locationIsTaken(1, 0)) {
        locations[1][0] = 'X';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player1 = sc.nextInt();
        player1Move(player1, sc);
      }
    } else if (player1 == 5) {
      if (!locationIsTaken(1, 1)) {
        locations[1][1] = 'X';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player1 = sc.nextInt();
        player1Move(player1, sc);
      }
    } else if (player1 == 6) {
      if (!locationIsTaken(1, 2)) {
        locations[1][2] = 'X';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player1 = sc.nextInt();
        player1Move(player1, sc);
      }
    } else if (player1 == 7) {
      if (!locationIsTaken(2, 0)) {
        locations[2][0] = 'X';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player1 = sc.nextInt();
        player1Move(player1, sc);
      }
    } else if (player1 == 8) {
      if (!locationIsTaken(2, 1)) {
        locations[2][1] = 'X';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player1 = sc.nextInt();
        player1Move(player1, sc);
      }
    } else if (player1 == 9) {
      if (!locationIsTaken(2, 2)) {
        locations[2][2] = 'X';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player1 = sc.nextInt();
        player1Move(player1, sc);
      }
    }
    if (checkWin('X')) {
      System.out.println("---------Player 1 wins!---------\n\n");
      winner = true;
    }
  }

  // for multiplayer: prompts player2 to enter input and checks if input is valid
  public static void player2Move(int player2, Scanner sc) {
    // add X to the location on board and print board and check if player 1 wins
    if (player2 == 1) {
      if (!locationIsTaken(0, 0)) {
        locations[0][0] = 'O';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player2 = sc.nextInt();
        player2Move(player2, sc);
      }
    } else if (player2 == 2) {
      if (!locationIsTaken(0, 1)) {
        locations[0][1] = 'O';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player2 = sc.nextInt();
        player1Move(player2, sc);
      }
    } else if (player2 == 3) {
      if (!locationIsTaken(0, 2)) {
        locations[0][2] = 'O';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player2 = sc.nextInt();
        player2Move(player2, sc);
      }
    } else if (player2 == 4) {
      if (!locationIsTaken(1, 0)) {
        locations[1][0] = 'O';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player2 = sc.nextInt();
        player2Move(player2, sc);
      }
    } else if (player2 == 5) {
      if (!locationIsTaken(1, 1)) {
        locations[1][1] = 'O';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player2 = sc.nextInt();
        player2Move(player2, sc);
      }
    } else if (player2 == 6) {
      if (!locationIsTaken(1, 2)) {
        locations[1][2] = 'O';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player2 = sc.nextInt();
        player2Move(player2, sc);
      }
    } else if (player2 == 7) {
      if (!locationIsTaken(2, 0)) {
        locations[2][0] = 'O';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player2 = sc.nextInt();
        player2Move(player2, sc);
      }
    } else if (player2 == 8) {
      if (!locationIsTaken(2, 1)) {
        locations[2][1] = 'O';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player2 = sc.nextInt();
        player2Move(player2, sc);
      }
    } else if (player2 == 9) {
      if (!locationIsTaken(2, 2)) {
        locations[2][2] = 'O';
        printBoard(locations);
      } else {
        System.out.println("Location is already taken. Enter another number: ");
        player2 = sc.nextInt();
        player2Move(player2, sc);
      }
    }
    if (checkWin('O')) {
      System.out.println("---------Player 2 wins!---------\n\n");
      winner = true;
    }
  }

  public static boolean locationIsTaken(int row, int col) {
    boolean isTaken = false;
    if (locations[row][col] == 'X' || locations[row][col] == 'O') {
      isTaken = true;
    }
    return isTaken;
  }

  public static boolean checkWin(char player) {
    boolean won = false;
    // check rows
    for (int i = 0; i < locations.length; i++) {
      if (locations[i][0] == player && locations[i][1] == player && locations[i][2] == player) {
        won = true;
      }
    }
    // check columns
    for (int i = 0; i < locations.length; i++) {
      if (locations[0][i] == player && locations[1][i] == player && locations[2][i] == player) {
        won = true;
      }
    }
    // check diagonals
    if (locations[0][0] == player && locations[1][1] == player && locations[2][2] == player) {
      won = true;
    }
    if (locations[0][2] == player && locations[1][1] == player && locations[2][0] == player) {
      won = true;
    }
    return won;
  }

  public static void singlePlayerEngine() {
    int numMoves = 0; // if this reaches 9 and no winner = false, then it's a tie
    Scanner sc = new Scanner(System.in);
    printBoard(locations);
    while (true) {
      // prompt player 1
      boolean repeat = false;
      System.out.println("Player 1 turn. Pick a location or 0 to quit: ");
      int player1 = sc.nextInt();
      if (player1 < 0 || player1 > 9) {
        repeat = true;
      } else {
        repeat = false;
      }
      while (repeat) {
        System.out.println("Invalid input. Please try again.");
        player1 = sc.nextInt();
        if (player1 < 0 || player1 > 9) {
          repeat = true;
        } else {
          repeat = false;
        }
      }
      if (player1 == 0) {
        System.out.println("Exiting Game");
        break;
      }
      player1Move(player1, sc);
      numMoves++;
      if (winner) {
        winner = false;
        numMoves = 0;
        break;
      }
      if (numMoves == 9) {
        System.out.println("It's a tie!\n");
        numMoves = 0;
        break;
      }

      // computer's turn
      System.out.println("The computer's turn:");
      computerMove();
      numMoves++;
      if (checkWin('O')) {
        numMoves = 0;
        System.out.println("---------Computer wins!---------\n\n");
        break;
      }
      if (numMoves == 9) {
        System.out.println("----- It's a tie! -----\n\n");
        numMoves = 0;
        break;
      }
    }
    // reset the board
    resetBoard();
    promptGameMode();
  }
  public static void computerMove() {
    int row = (int) (Math.random() * 3);
    int col = (int) (Math.random() * 3);
    while(locationIsTaken(row, col)){
      row = (int) (Math.random() * 3);
      col = (int) (Math.random() * 3);
    }
    locations[row][col] = 'O';
    printBoard(locations);
  }

  public static void resetBoard() {
    char[][] newBoard = new char[][] { { '1', '2', '3' },
        { '4', '5', '6' },
        { '7', '8', '9' } };
    locations = newBoard;
  }

  public static void printBoard(char[][] locations) {
    for (int i = 0; i < locations.length; i++) {
      for (int j = 0; j < locations[i].length; j++) {
        if (j < locations[i].length - 1) {
          System.out.print(locations[i][j] + " | ");
        } else {
          System.out.print(locations[i][j]);
        }

      }
      if (i < locations.length - 1) {
        System.out.println("\n---------");
      } else {
        System.out.println();
      }
    }
    System.out.println();
  }
}
