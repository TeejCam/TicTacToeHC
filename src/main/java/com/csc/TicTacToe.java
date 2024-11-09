package com.csc;
import java.util.Scanner;


public class TicTacToe
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Please choose a game mode: ");
        System.out.println("1) Human vs. Human");
        System.out.println("2) Human vs. Computer");

        menuChoice(1, 2, "Goodbye!");
    }

    public static int menuChoice(int choice1, int choice2, String exPrompt)
    {
        String userIn;
        //System.out.println(welcPrompt);
        Scanner scanner = new Scanner(System.in);

        boolean invalidValue = true;
        int returnValue = -1;
     
        while(invalidValue){
            userIn = scanner.nextLine();
            returnValue = Integer.parseInt(userIn);

            if(returnValue == choice1){
                System.out.println("Starting human vs human game:");
                HumanVHuman game1 = new HumanVHuman();
                game1.Start();
                return returnValue;
            }
            else if(returnValue == choice2){
                System.out.println("Starting computer vs human game:");
                ComputerVHuman game2 = new ComputerVHuman();
                game2.Start();
                return returnValue;
            }
            else{
                System.out.println(exPrompt);
                return returnValue;
            }
        }
        return returnValue;
    }

}
