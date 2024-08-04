package org.lld.conceptCoding.questions.TicTacToe.GameInfo;

import org.lld.conceptCoding.questions.TicTacToe.pieceInfo.PlayingPiece;

public class Board {
    private final PlayingPiece[][] board;
    private final int size;
    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }
    public PlayingPiece[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public Boolean areFreeCellsAvailable(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == null) return true;
            }
        }
        return false;
    }
    public boolean move(PlayingPiece piece, CordinatePair pair){
        if(pair.x>size-1 || pair.y > size-1 || board[pair.x][pair.y] != null) return false;
        else board[pair.x][pair.y] = piece; return true;
    }
    public void printBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j] == null) System.out.print("| "+ "|");
                else System.out.print("|" + board[i][j]+ "|");
            }
            System.out.println();
        }
    }

    public boolean isThereAWinner(CordinatePair move, PlayingPiece pieceType) {
        int rowCount = 0;
        int columnCount = 0;
        int diagnoalCount = 0;
        int antiDiagnoalCount = 0;
        int x = move.x;
        int y = move.y;
        int xStart = 0;
        int yStart = 0;
        boolean checkDiagonal = true;
        if(x < y){
            yStart = y-x;
            checkDiagonal = false;
        }
        else if(x > y){
            xStart = x-y;
            checkDiagonal =false;
        }
        for(int cnt =0; cnt<size; cnt++){
            if(board[x][cnt] != null && board[x][cnt] == pieceType) {
                rowCount++;
            }
            if(board[cnt][y] != null && board[cnt][y] == pieceType) {
                columnCount++;
            }
            if(checkDiagonal){
                if((board[xStart+cnt][yStart+cnt] == pieceType)){
                    diagnoalCount++;
                }
                if(board[xStart+cnt][size-1-cnt] == pieceType){
                    antiDiagnoalCount++;
                }
            }
        }
        if(rowCount == size || columnCount == size || diagnoalCount == size || antiDiagnoalCount == size){
            return true;
        }
        return false;
    }
}
