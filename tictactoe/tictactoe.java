/******************************************************************************

Simple TicTacToe Game for 2022 Intro to Java Class  
Created by Micah G

*******************************************************************************/

import java.util.*;

public class tictactoe
{
	public static void main(String[] args) {
		Scanner ttt = new Scanner(System.in);
		int[] intList= {0,0,0,0,0,0,0,0,0};
		int gameOver = 0;
		
		int i = 0;
		while (i < 9 && gameOver == 0) {
		    if (i % 2 == 0) {
		        System.out.println("Hello player x,\nInsert number from 1 thru 9, in order of left to right\n");
		    } else {
		        System.out.println("Hello player o,\nInsert number from 1 thru 9, in order of left to right\n");
		    }
		    int input = ttt.nextInt();
		    input = checkNum(intList, input, ttt);
		    intList = addNum(intList, input, i);
		    gameOver = checkWin(intList);
		    formatBoard(intList);
		    i++;
		} 
		if (gameOver == 1){
		    System.out.println("Congrats player x, you won!");
		} else if (gameOver == 2) {
		    System.out.println("Congrats player o, you won!");
		} else {
		    System.out.println("Game has resulted in a tie.");
		}
	}
	public static void formatBoard(int[] list) {
	    // changes int array to output in x and o
	    String[] newList = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
	    for (int i = 0; i < 9; i++) {
	        if (list[i] == 1) {
	            newList[i] = "x";
	        } else if (list[i] == 2) {
	            newList[i] = "o";
	        }
	    }
	    // format and output rows
	    String row1, row2, row3, horzBord, outBoard;
	    row1 = String.format(" %1$s | %2$s | %3$s ", newList[0], newList[1], newList[2]);
	    row2 = String.format(" %1$s | %2$s | %3$s ", newList[3], newList[4], newList[5]);
	    row3 = String.format(" %1$s | %2$s | %3$s ", newList[6], newList[7], newList[8]);
	    horzBord = "\n-----------\n";
	    outBoard = String.format("\n%1$s%4$s%2$s%4$s%3$s\n", row1, row2, row3, horzBord);
	    System.out.println(outBoard);
	}
	public static int checkNum(int[] list, int input, Scanner ttt) {
	    // makes sure input is in valid range and not already selected
	    if (input < 10) {
            while(list[input-1] != 0) {
                System.out.println("this spot is already taken. retry");
                input = ttt.nextInt();
            }
	    } else {
	        while(input >= 10) {
	            System.out.println("input is invalid. retry");
	            input = ttt.nextInt();
	            }
	        while(list[input-1] != 0) {
                System.out.println("this spot is already taken. retry");
                input = ttt.nextInt();
	            }
	        }
	    return input;
	}
	public static int checkWin(int[] list) {
	    // checks if sum of selected nums is zero for unselected spaces
	    int zeroVal;
	    int num = 0;
	    // checks rows
	    for (int i = 0; i < 3; i++) {
	        zeroVal = list[num] + list[num+1] + list[num+2];
	        if (list[num] == list[num+1] && list[num+1] == list[num+2] && zeroVal != 0) {
	            return list[num];
	        } num += 3;
        // checks columns
        for (int p = 0; p < 3; p++) {
            zeroVal = list[p] + list[p+3] + list[p+6];
            if (list[p] == list[p+3] && list[p+3] == list[p+6] && zeroVal != 0)
                return list[p];
            }
	    }
	    // checks diaganals
	    zeroVal = list[0] + list[4] + list[8];
	    if (list[0] == list[4] && list[4] == list[8] && zeroVal != 0) {
	        return list[0];
	    }
	    zeroVal = list[2] + list[4] + list[6];
	    if (list[2] == list[4] && list[4] == list[6] && zeroVal != 0) {
	        return list[2];
	    }
	    return 0;
	}
	public static int[] addNum(int[] list, int input, int turn) {
	    // adds number to list
	    if (turn % 2 == 0) {
	        list[input-1] = 1;
	    } else {
	        list[input-1] = 2;
	    }
	    return list;
	}
}




