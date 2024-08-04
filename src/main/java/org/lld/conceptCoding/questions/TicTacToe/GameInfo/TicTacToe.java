package org.lld.conceptCoding.questions.TicTacToe.GameInfo;

import org.lld.conceptCoding.questions.TicTacToe.pieceInfo.PieceO;
import org.lld.conceptCoding.questions.TicTacToe.pieceInfo.PieceX;
import org.lld.conceptCoding.questions.TicTacToe.pieceInfo.PlayingPiece;
import org.lld.conceptCoding.questions.TicTacToe.playerInfo.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    private final Deque<Player> players;
    private final Board board;
    private GameState gameState;
    public TicTacToe(Deque<Player> players, Board board) {
        this.players = players;
        this.board = board;
        gameState = GameState.INITIALIZED;
    }
    public Deque<Player> getPlayers() {
        return players;
    }
    public Board getBoard() {
        return board;
    }
    public String startGame(){
        gameState = GameState.PLAYING;
        String winner = "";
        while(gameState.equals(GameState.PLAYING)) {
            //check if game is over or no spaces left to fill
            Player playerTurn = players.removeFirst();
            if (!board.areFreeCellsAvailable()) {
                return GameState.TIE.toString();
            }
            board.printBoard();
            System.out.println(playerTurn.getName() + "Please enter the coordinates(, separated) to mark");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            CordinatePair move = new CordinatePair(Integer.valueOf(values[0]),Integer.valueOf(values[1]));
            if(!board.move(playerTurn.getPieceType(), move)){
                players.addFirst(playerTurn);
                System.out.println("Provided Coordinate is Invalid!");
                continue;
            }
            else{
                players.addLast(playerTurn);
            }
            if (board.isThereAWinner(move, playerTurn.getPieceType())) {
                gameState = GameState.ENDED;
                winner = playerTurn.getName();
            }
        }
        if(gameState == GameState.TIE){
            return GameState.TIE.toString();
        }
        return winner + "is The Winner";
    }
}
