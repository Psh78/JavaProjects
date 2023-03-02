/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;
import java.util.*;
public class Main
{
    
	static Scanner sc = new Scanner(System.in);
	
    static void displayBoard(char [][] game) {
        for(int i = 0; i < game.length; i++) {
            for(int j = 0; j < game.length; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static char choiceFunc(ArrayList<Character> list) {
        char choice = sc.next().charAt(0);
        while((choice > '9' || choice < '1') || list.contains(choice)) {
            System.out.println("Invalid Choice. Enter Choice between 0 to 9:");
            choice = sc.next().charAt(0);
        }
        return choice;
    }
    /*
        00 01 02
        10 11 12
        20 21 22
    */
    static int gameOver(char [][] game) {
        if((game[0][0] == 'x' && game[0][1] == 'x' && game[0][2] == 'x') || (game[1][0] == 'x' && game[1][1] == 'x' && game[1][2] == 'x') ||
           (game[2][0] == 'x' && game[2][1] == 'x' && game[2][2] == 'x') || (game[0][0] == 'x' && game[1][0] == 'x' && game[2][0] == 'x') ||
           (game[0][1] == 'x' && game[1][1] == 'x' && game[2][1] == 'x') || (game[0][2] == 'x' && game[1][2] == 'x' && game[2][2] == 'x') || 
           (game[0][0] == 'x' && game[1][1] == 'x' && game[2][2] == 'x') || (game[0][2] == 'x' && game[1][1] == 'x' && game[2][0] == 'x') ) 
        {
            return 0;
        }
        else if((game[0][0] == 'o' && game[0][1] == 'o' && game[0][2] == 'o') || (game[1][0] == 'o' && game[1][1] == 'o' && game[1][2] == 'o') ||
           (game[2][0] == 'o' && game[2][1] == 'o' && game[2][2] == 'o') || (game[0][0] == 'o' && game[1][0] == 'o' && game[2][0] == 'o') ||
           (game[0][1] == 'o' && game[1][1] == 'o' && game[2][1] == 'o') || (game[0][2] == 'o' && game[1][2] == 'o' && game[2][2] == 'o') || 
           (game[0][0] == 'o' && game[1][1] == 'o' && game[2][2] == 'o') || (game[0][2] == 'o' && game[1][1] == 'o' && game[2][0] == 'o') ) 
        {
            return 1;
        } else  {
            return -1;
        }
    }
    
	public static void main(String[] args) {
		
		ArrayList<Character> list = new ArrayList<Character>();
		
        boolean playerOneWon = false;
        boolean playerTwoWon = false;
        
        int count = 0;  // To check the player turn
        
        char [][] gameBoard = new char[3][3];
        
        //Initial Game setup
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = '_';
            }
        }
        
        System.out.println("*** TIC TAC TOE ***\nPlayer-1: x\nPlayer-2: o");
        displayBoard(gameBoard);
        System.out.println();
        while(playerOneWon == false && playerTwoWon == false) {  
            char choice = '0'; // to choose the grid number
            
            if(count % 2 == 0) {
                System.out.println("Enter Player-1 your row choice: 0 to 9:");
                choice = choiceFunc(list);
                list.add(choice);
            } else {
                System.out.println("Enter Player-2 your row choice: 0 to 9:");
                choice = choiceFunc(list);
                list.add(choice);
            }
            choice = Character.valueOf(choice);
            if(count % 2 == 0) {
                switch(choice) {
                    case '1' : gameBoard[0][0] = 'x';
                    break;
                    case '2' : gameBoard[0][1] = 'x';
                    break;
                    case '3' : gameBoard[0][2] = 'x';
                    break;
                    case '4' : gameBoard[1][0] = 'x';
                    break;
                    case '5' : gameBoard[1][1] = 'x';
                    break;
                    case '6' : gameBoard[1][2] = 'x';
                    break;
                    case '7' : gameBoard[2][0] = 'x';
                    break;
                    case '8' : gameBoard[2][1] = 'x';
                    break;
                    case '9' : gameBoard[2][2] = 'x';
                    break;
                }
            } else {
                switch(choice) {
                    case '1' : gameBoard[0][0] = 'o';
                    break;
                    case '2' : gameBoard[0][1] = 'o';
                    break;
                    case '3' : gameBoard[0][2] = 'o';
                    break;
                    case '4' : gameBoard[1][0] = 'o';
                    break;
                    case '5' : gameBoard[1][1] = 'o';
                    break;
                    case '6' : gameBoard[1][2] = 'o';
                    break;
                    case '7' : gameBoard[2][0] = 'o';
                    break;
                    case '8' : gameBoard[2][1] = 'o';
                    break;
                    case '9' : gameBoard[2][2] = 'o';
                    break;
                }
            }
            count++;
            int result = gameOver(gameBoard);
            displayBoard(gameBoard);
            if(result == 0) {
                playerOneWon = true;
            }
            else if(result == 1) {
                playerTwoWon = true;
            }
            if(list.size() == 9 && (playerOneWon == false && playerTwoWon == false)) {
                for(int i = 0; i < gameBoard.length; i++) {
                    for(int j = 0; j < gameBoard.length; j++) {
                        gameBoard[i][j] = '_';
                    }
                }   
                list.clear();
                System.out.println("It's a Draw!!!");
                break;
            }
        }
        if(playerOneWon) {
            System.out.println("Player-1 Won !!!");
        } else if(playerTwoWon) {
            System.out.println("Player-2 Won !!!");
        }
 	}
}
