import java.util.Scanner;
import java.util.ArrayList;
public class TicTacToeGame {
      
   public static void main(String[] args) {
   String[] playerNames = new String[2];
   char[] boardState = new char[9];
   
   credits();
       
      for (int i = 0; i < 9; i++) {
         boardState[i] = Character.forDigit(i, 10);
      }  
          
   getUserNames(playerNames);
   switchPlayer(playerNames, boardState);
   
   }  
   
   public static void getUserNames(String[] playerNames) {
   Scanner in = new Scanner(System.in);
   String x = "first";
   char letter = 'X';
      for (int i = 0; i < playerNames.length; i++) {
         System.out.println("Will the " + x + " player enter their name(this player will be " + letter + "): ");
         playerNames[i] = in.nextLine();
         playerNames[i] = validateNames(playerNames[i]);
         x = "second";
         letter = 'O';
      }
   }
   
   public static String validateNames(String playerName) {
   Scanner in = new Scanner(System.in);
   int playerNameLength = playerName.length();
   int counter = 0;
   
      while (playerNameLength == 0) {
         System.out.println("No blank spaces, please try again and enter your first name: ");
         playerName = in.nextLine();
         playerNameLength = playerName.length();
      }
   
         while (counter < playerNameLength) {
            if (!Character.isLetter(playerName.charAt(counter))) {
               System.out.println("Please enter only your first name with no spaces or numbers: ");
               playerName = in.nextLine();
               playerNameLength = playerName.length();
               counter = 0;
            } else {
               counter++;
            }
               while (playerNameLength == 0) {
                  System.out.println("No blank spaces, please try again and enter your first name: ");
                  playerName = in.nextLine();
                  playerNameLength = playerName.length();
               }
         }
         return playerName;
   }
   
   public static void switchPlayer(String[] playerNames, char[] boardState) {
   Scanner in = new Scanner(System.in);
   
      for (int i = 0; i < 9; i++) {
         if (i % 2 == 0) {
            displayGrid(boardState);
            System.out.println("It is " + playerNames[0] + "'s turn now: ");
            String move = in.nextLine();
            playerMakeMove(move, playerNames[0], boardState, playerNames);
            checkWin(playerNames[0], boardState);
         } else {
            displayGrid(boardState);
            System.out.println("It is " + playerNames[1] + "'s turn now: ");
            String move = in.nextLine();
            playerMakeMove(move, playerNames[1], boardState, playerNames);
            checkWin(playerNames[1], boardState);   
         }
      }
      displayGrid(boardState);
      System.out.println("Nice try but it ended in a tie!");
      resetGame(boardState);
   }
   
   public static void displayGrid(char[] boardState) {
   System.out.println("-----");
   System.out.println(boardState[0] + "|" + boardState[1] + "|" + boardState[2]);
   System.out.println("-----"); 
   System.out.println(boardState[3] + "|" + boardState[4] + "|" + boardState[5]);
   System.out.println("-----");
   System.out.println(boardState[6] + "|" + boardState[7] + "|" + boardState[8]);
   System.out.println("-----");
   }
   
   public static void playerMakeMove(String move, String playerName, char[] boardState, String[] playerNames) {
   move = validatePlayersMove(move);
   checkPositionAvailability(move, playerName, boardState, playerNames);   
   }
   
   public static String validatePlayersMove(String move) {
   Scanner in = new Scanner(System.in);
   int moveLength = move.length();
   
   ArrayList<String> list = new ArrayList<String>(9);
   list.add("0");
   list.add("1");
   list.add("2");
   list.add("3");
   list.add("4");
   list.add("5");
   list.add("6");
   list.add("7");
   list.add("8");
         
      while(moveLength == 0) {
         System.out.println("No blank spaces, please try again and enter a valid option: ");
         move = in.nextLine();
         moveLength = move.length();
      }
   
         while (!list.contains(move))
            {  
               if (!list.contains(move)) {
                  System.out.println("Enter a valid option from 0-8: ");
                  move = in.nextLine();
                  moveLength = move.length();
               }               
                  while (moveLength == 0) {
                     System.out.println("No blank spaces, please try again and enter a valid option: ");
                     move = in.nextLine();
                     moveLength = move.length();  
                  }
            
            }      
      return move;      
   }
   
   public static void checkPositionAvailability(String move, String playerName, char[] boardState, String[] playerNames) {
   int moveInt = Integer.parseInt(move);
   Scanner in = new Scanner(System.in);
      while (boardState[moveInt] == 'O' || boardState[moveInt] == 'X') {
         System.out.println("Please choose another space: ");
         move = in.nextLine();
         move = validatePlayersMove(move);
         moveInt = Integer.parseInt(move);
      }
         if (playerName == playerNames[0]) {
            boardState[moveInt] = 'X';
         } else {
            boardState[moveInt] = 'O';
         }       
   }
   
   public static void checkWin(String playerName, char[] boardState) {
      if (boardState[0] == 'X' && boardState[1] == 'X' && boardState[2] == 'X' || boardState[0] == 'O' && boardState[1] == 'O' && boardState[2] == 'O') {
         displayGrid(boardState);
         System.out.println("Congratulations " + playerName + " you have won the game!");
         resetGame(boardState);
      } else if (boardState[3] == 'X' && boardState[4] == 'X' && boardState[5] == 'X' || boardState[3] == 'O' && boardState[4] == 'O' && boardState[5] == 'O') {
         displayGrid(boardState);
         System.out.println("Congratulations " + playerName + " you have won the game!");
         resetGame(boardState);      
      } else if (boardState[6] == 'X' && boardState[7] == 'X' && boardState[8] == 'X' || boardState[6] == 'O' && boardState[7] == 'O' && boardState[8] == 'O') {
         displayGrid(boardState);
         System.out.println("Congratulations " + playerName + " you have won the game!");
         resetGame(boardState);   
      } else if (boardState[0] == 'X' && boardState[3] == 'X' && boardState[6] == 'X' || boardState[0] == 'O' && boardState[3] == 'O' && boardState[6] == 'O') {
         displayGrid(boardState);
         System.out.println("Congratulations " + playerName + " you have won the game!");
         resetGame(boardState);
      } else if (boardState[1] == 'X' && boardState[4] == 'X' && boardState[7] == 'X' || boardState[1] == 'O' && boardState[4] == 'O' && boardState[7] == 'O') {
         displayGrid(boardState);
         System.out.println("Congratulations " + playerName + " you have won the game!");
         resetGame(boardState);
      } else if (boardState[2] == 'X' && boardState[5] == 'X' && boardState[8] == 'X' || boardState[2] == 'O' && boardState[5] == 'O' && boardState[8] == 'O') {
         displayGrid(boardState);
         System.out.println("Congratulations " + playerName + " you have won the game!");
         resetGame(boardState);
      } else if (boardState[0] == 'X' && boardState[4] == 'X' && boardState[8] == 'X' || boardState[0] == 'O' && boardState[4] == 'O' && boardState[8] == 'O') {
         displayGrid(boardState);
         System.out.println("Congratulations " + playerName + " you have won the game!");
         resetGame(boardState);
      } else if (boardState[2] == 'X' && boardState[4] == 'X' && boardState[6] == 'X' || boardState[2] == 'O' && boardState[4] == 'O' && boardState[6] == 'O') {
         displayGrid(boardState);
         System.out.println("Congratulations " + playerName + " you have won the game!");
         resetGame(boardState);
      } else {
         System.out.println();
      }        
   }
   
   public static void resetGame(char[] boardState) {
   Scanner in = new Scanner(System.in);
   System.out.println("Would you like to play again? Press y/Y to play again, or any other character to exit...");
   char input = in.next().charAt(0);
   
   String[] playerNames = new String[2];
   
      if (input == 'y' || input == 'Y') {
         for (int i = 0; i < 9; i++) {
            boardState[i] = Character.forDigit(i, 10);
         }   
         getUserNames(playerNames);
         switchPlayer(playerNames, boardState);   
      } else {
         System.exit(0);
      }          
   }
   
   public static void credits() {
   Scanner in = new Scanner(System.in);
   System.out.println("**********************");
   System.out.println("**********************");
   System.out.println("**********************");
   System.out.println("** TicTacToe Game   **");
   System.out.println("** By Benny Vasquez **");
   System.out.println("**********************");
   System.out.println("**********************");
   System.out.println("**********************");
   System.out.println("Press any key to continue...");
   in.nextLine();
   }
      
}