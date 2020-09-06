package com.ibm.oj.games;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit; 

public class TicTacToe {
    
    static char[][] matrix = new char[][] {
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' },
    };
    
    static State state =  new State();
    
    public static class State{
        String s00 = "";
        String s01 = "";
        String s02 = "";
        String s10 = "";
        String s11 = "";
        String s12 = "";
        String s20 = "";
        String s21 = "";
        String s22 = "";

        public String[] getRows() {
            return new String[] {
                    s00+s01+s02,
                    s10+s11+s12,
                    s20+s21+s22,
                    s00+s10+s20,
                    s01+s11+s21,
                    s02+s12+s22,
                    s00+s11+s22,
                    s02+s11+s20
            };
        }
        
    }
    
    public static void main(String[] args){
       Random rand = new Random(); 
       int player =  rand.nextInt(2);
       boolean playerWon =  false;
       LinkedList<String> square = new LinkedList<String>();
       square.add("0-0");
       square.add("0-1");
       square.add("0-2");
       square.add("1-0");
       square.add("1-1");
       square.add("1-2");
       square.add("2-0");
       square.add("2-1");
       square.add("2-2");
       
       int numberOfElements = 9;
       
       
       for (int i = 0; i < numberOfElements; i++) {
           try {
               System.out.println("--------------");
               player = player == 1 ? 0:1;
               System.out.println("Turn: "+ i + " - Player: " + getPlayer(player));
               int randomIndex = rand.nextInt(square.size());
               String randomElement = square.get(randomIndex);
//               System.out.println("randomElement "+randomElement);
               setState(randomElement, player);
               markOnMatrix(randomElement, player);
               square.remove(randomIndex);
               System.out.println("--------------");
               printMatrix();
               TimeUnit.SECONDS.sleep(2);
               if(hasPlayerWon()) {
                   playerWon = true;
                   break;
               }    
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           
       }
       
//       System.out.println("isEmpty "+ square.isEmpty());
       if(playerWon)
           System.out.println("Player " + getPlayer(player) + " wins ");
       else
       System.out.println("Nobody wins");

    }
    
    private static boolean hasPlayerWon() {
        String [] matchedLines = getMatchedLines();
        for(String line: state.getRows()) {
            if(line.equals(matchedLines[0]) || line.equals(matchedLines[1]) )
                return true;
        }
        return false;
    }

    private static void setState(String randomElement, int player) {
        
        switch(randomElement) 
        { 
            case "0-0": 
                state.s00 = String.valueOf(getPlayer(player)); 
                break; 
            case "0-1": 
                state.s01 = String.valueOf(getPlayer(player)); 
                break;
            case "0-2": 
                state.s02 = String.valueOf(getPlayer(player)); 
                break;
            case "1-0": 
                state.s10 = String.valueOf(getPlayer(player)); 
                break;
            case "1-1": 
                state.s11 = String.valueOf(getPlayer(player)); 
                break;
            case "1-2": 
                state.s12 = String.valueOf(getPlayer(player)); 
                break;
            case "2-0": 
                state.s20 = String.valueOf(getPlayer(player)); 
                break;
            case "2-1": 
                state.s21 = String.valueOf(getPlayer(player)); 
                break;
            case "2-2": 
                state.s22 = String.valueOf(getPlayer(player)); 
                break;    
             
        } 
        
        
    }

    private static void markOnMatrix(String randomElement, int player) {
        int x = 0;
        int y = 0;
        String[] indexes = randomElement.split("-");
        x = Integer.valueOf(indexes[0]);
        y = Integer.valueOf(indexes[1]);
        matrix[x][y] = getPlayer(player);
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { //this equals to the column in each row.
               System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
         }
        
    }
    
    private static char getPlayer(int player) {
        return player == 1 ? 'X':'O';
    }
    
    private static String[] getMatchedLines() {
        String[] matchLines =  new String[] { "XXX","OOO"};
        return matchLines;
    }

}
