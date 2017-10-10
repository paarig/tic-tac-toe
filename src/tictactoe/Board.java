/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author paari
 */
public class Board {

    private int[][] board;

    public Board() {
        board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = -1;
            }
        }
    }

    public void addX(int x, int y) {
        board[x][y] = 1;
    }

    public void addO(int x, int y) {
        board[x][y] = 0;
    }

    public boolean gameIsDone() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]==-1){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int getValue(int x, int y){
        return board[x][y];
    }
    
    public boolean Xwins(){
        if(horizontalWin(1)){
            return true;
        }
        else if(verticalWin(1)){
            return true;
        }
        else if(diagonalWin(1)){
            return true;
        }
        else{
            return false;
        }        
    }
    
    public boolean Owins(){
        if(horizontalWin(0)){
            return true;
        }
        else if(verticalWin(0)){
            return true;
        }
        else if(diagonalWin(0)){
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean horizontalWin(int val){
        for(int i=0;i<3;i++){
            if(board[i][0]==val&&board[i][1]==val&&board[i][2]==val){
                return true;
            }    
        }
        return false;
    }
    
    private boolean verticalWin(int val){
        for(int i=0;i<3;i++){
            if(board[0][i]==val&&board[1][i]==val&&board[2][i]==val){
                return true;
            }    
        }
        return false;        
    }
    
    private boolean diagonalWin(int val){
            if(board[0][0]==val&&board[1][1]==val&&board[2][2]==val){
                return true;
            }  
            else if(board[0][2]==val&&board[1][1]==val&&board[2][0]==val){
                return true;
            }  
        return false;
    }

}
