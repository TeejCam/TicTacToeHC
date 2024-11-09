package com.csc;
import java.util.Scanner;

public class HumanVHuman
{
    private boolean isValidMove(char[][] board, String position)
    {
        switch(position)
        {
            case "1": 
                return (board[0][0] == ' '); //this returns the truth value of this statement!
            
            case "2":
                return (board[0][1] == ' ');
            
            case "3":
                return (board[0][2] == ' ');
            
            case "4":
                return (board[1][0] == ' ');
            
            case "5":
                return (board[1][1] == ' ');
            
            case "6":
                return (board[1][2] == ' ');
            
            case "7":
                return (board[2][0] == ' ');
            
            case "8":
                return (board[2][1] == ' ');
            
            case "9":
                return (board[2][2] == ' ');
            
            default:
                return false;
        }
    }

    private void placeMove(char[][] board, String position, char symbol)
    {
        switch(position)
        {
            case "1": 
                board[0][0] = symbol;
                break;
            
            case "2":
                board[0][1] = symbol;
                break;
            
            case "3":
                board[0][2] = symbol;
                break;
            
            case "4":
                board[1][0] = symbol;
                break;
            
            case "5":
                board[1][1] = symbol;
                break;
            
            case "6":
                board[1][2] = symbol;
                break;
            
            case "7":
                board[2][0] = symbol;
                break;
            
            case "8":
                board[2][1] = symbol;
                break;
            
            case "9":
                board[2][2] = symbol;
                break;
            
            default:
                System.out.println("You suck.");
        }
    }


    private void playerOneTurn(char[][] board, Scanner scanner)
    {
        String userInput;
        while (true){
            System.out.println("Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if(isValidMove(board, userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid position! Try again: ");
            }
        }
        placeMove(board, userInput, 'X');
    }

    private void playerTwoTurn(char[][] board, Scanner scanner)
    {
        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if(isValidMove(board, userInput)){
                break;
            }
            else {
                System.out.println(userInput + " is not a valid position! Try again: ");
            }
        }
        placeMove(board, userInput, 'O');
    }

    private static boolean hasContestantWon(char[][] board, char symbol)
    {
        if((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) || 
           (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
           (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
           
           (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) || 
           (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
           (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
           
           (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) || 
           (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
        
            return true;
           }
           return false;
    }

    private boolean isGameFinished(char[][] board)
    {
        if(hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player 1 wins!");
            return true;
        }
        else if (hasContestantWon(board, 'O')) {
            System.out.println("Player 2 wins!");
            return true;
        }

        for (int i=0; i < board.length; i++){
            for (int j=0; j < board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    private void printBoard(char[][] board)
    {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    public void Start()
    {
        //we must print a board first
        //three rows of three characters apiece
        Scanner scanner = new Scanner(System.in); 
        char[][] board = {{' ', ' ', ' '}, 
                          {' ', ' ', ' '}, 
                          {' ', ' ', ' '}}; //this is what our board looks like
        
        printBoard(board);
        //we need a way to take user input
        //human input
        //int playerNum;
        //System.out.println("Pick either 1 or 2: ");
        //playerNum = scanner.nextInt();

        while (true){
            playerOneTurn(board, scanner);
            if (isGameFinished(board)){
                break;
            }
            printBoard(board);

            playerTwoTurn(board, scanner);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);
        }
        scanner.close();
    }
}