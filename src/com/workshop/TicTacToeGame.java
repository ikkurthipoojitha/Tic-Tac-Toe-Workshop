package com.workshop;

import java.util.Scanner;

import java.util.Random;

    public class TicTacToeGame {


        public static char comp, player;
        static char[] board;

        public static char[] create() {

            board = new char[10];
            for (int a = 1; a < board.length; a++) {
                board[a] = ' ';
            }

            return board;
        }

        public static void choice() {

            System.out.println("choose x or o ");
            Scanner s = new Scanner(System.in);
            player = s.next().charAt(0);

            if (player == 'X') {
                comp = 'O';
            } else {
                comp = 'X';
            }
            System.out.println("user choice :" + player);
            System.out.println("Computer " + comp);
        }

        public static void showBoard(char[] board) {

            System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
            System.out.println("-----------");
            System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
            System.out.println("-----------");
            System.out.println(board[7] + " | " + board[8] + " | " + board[9]);

        }

        public static void placeMove(char[] board, String position, char symbol) {


            switch (position) {
                case "1":
                    board[1] = symbol;
                    break;
                case "2":
                    board[2] = symbol;
                    break;
                case "3":
                    board[3] = symbol;
                    break;
                case "4":
                    board[4] = symbol;
                    break;
                case "5":
                    board[5] = symbol;
                    break;
                case "6":
                    board[6] = symbol;
                    break;
                case "7":
                    board[7] = symbol;
                    break;
                case "8":
                    board[8] = symbol;
                    break;
                case "9":
                    board[9] = symbol;
                    break;
                default:
                    System.out.println(":(");
            }
        }

        public static boolean isValidMove(char[] board, String position) {

            switch (position) {
                case "1":
                    return (board[1] == ' ');
                case "2":
                    return (board[2] == ' ');
                case "3":
                    return (board[3] == ' ');
                case "4":
                    return (board[4] == ' ');
                case "5":
                    return (board[5] == ' ');
                case "6":
                    return (board[6] == ' ');
                case "7":
                    return (board[7] == ' ');
                case "8":
                    return (board[8] == ' ');
                case "9":
                    return (board[9] == ' ');
                default:
                    return false;
            }
        }

        public static boolean isGameFinished(char[] board) {

            if (hasContestantWon(board, 'X')) {
                showBoard(board);
                System.out.println("Player wins!");
                return true;
            }

            if (hasContestantWon(board, 'O')) {
                showBoard(board);
                System.out.println("Computer wins!");
                return true;
            }

            for (int i = 0; i < board.length; i++) {
                if (board[i] == ' ') {
                    return false;
                }

            }
            showBoard(board);
            System.out.println("The game ended in a tie!");
            return true;
        }


        private static boolean hasContestantWon(char[] board, char symbol) {
            if ((board[1] == symbol && board[2] == symbol && board[3] == symbol) ||
                    (board[4] == symbol && board[5] == symbol && board[6] == symbol) ||
                    (board[7] == symbol && board[8] == symbol && board[9] == symbol) ||

                    (board[1] == symbol && board[4] == symbol && board[7] == symbol) ||
                    (board[2] == symbol && board[5] == symbol && board[8] == symbol) ||
                    (board[3] == symbol && board[6] == symbol && board[9] == symbol) ||

                    (board[1] == symbol && board[5] == symbol && board[9] == symbol) ||
                    (board[3] == symbol && board[5] == symbol && board[7] == symbol)) {
                return true;
            }
            return false;
        }


        private static void computerTurn(char[] board) {
            Random rand = new Random();
            int computerMove;
            while (true) {
                computerMove = rand.nextInt(9) + 1;
                if (isValidMove(board, Integer.toString(computerMove))) {
                    break;
                }
            }
            System.out.println("Computer chose " + computerMove);
            placeMove(board, Integer.toString(computerMove), 'O');
        }

        public static void playerTurn(char[] board, Scanner scanner) {
            String userInput;
            //int position = s.nextInt();
            //isValidMove(board,Integer.toString(position));
            //placeMove(board, Integer.toString(position), 'O');

            while (true) {
                System.out.println("Enter Your Move!!");
                userInput = scanner.nextLine();
                if (isValidMove(board, userInput)) {
                    break;
                } else {
                    System.out.println(userInput + " is not a valid move.");
                }
            }
            placeMove(board, userInput, 'X');
        }
    }




