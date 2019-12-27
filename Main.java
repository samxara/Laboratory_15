package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        TicTacToe game = new TicTacToe();
        game.printGrid();

        while(!game.playerHasWon() && !game.isDraw()){
            System.out.println("Player");
            playerPlay(game);
            if (game.playerHasWon()){
                System.out.println("We have a winner");
                return;
            } else if (game.isDraw()){
                System.out.println("it is a draw");
                return;
            }
            System.out.println("Computer");
            computerPlay(game);
        }
        if (game.playerHasWon()) {
            System.out.println("We have a winner");
            return;
        }
        System.out.println("It's a draw");
    }

    public static void computerPlay(TicTacToe game){
        Random random = new Random();
        int position = random.nextInt(10);
        while(!game.positionIsFree(position)){
            position = random.nextInt(10);
        }
        game.placeChar(position);
        game.printGrid();
    }

    public static void playerPlay(TicTacToe game){
        Scanner sc = new Scanner(System.in);
        int position = sc.nextInt();
        while(!game.positionIsFree(position)){
            System.out.println("position is taken, input new position");
            position = sc.nextInt();
        }
        game.placeChar(position);
        game.printGrid();
    }
}