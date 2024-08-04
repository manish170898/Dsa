package org.lld.conceptCoding.questions.TicTacToe;

import org.lld.conceptCoding.questions.TicTacToe.GameInfo.Board;
import org.lld.conceptCoding.questions.TicTacToe.GameInfo.TicTacToe;
import org.lld.conceptCoding.questions.TicTacToe.pieceInfo.PieceO;
import org.lld.conceptCoding.questions.TicTacToe.pieceInfo.PieceX;
import org.lld.conceptCoding.questions.TicTacToe.pieceInfo.PlayingPiece;
import org.lld.conceptCoding.questions.TicTacToe.playerInfo.Player;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PlayingPiece crossPiece = new PieceX();
        PlayingPiece circlePiece = new PieceO();
        Player player1 = new Player("Manish", crossPiece);
        Player player2 = new Player("Shivang", circlePiece);
        Deque<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        Board board = new Board(3);
        TicTacToe ticTacToe = new TicTacToe(players, board);
        System.out.println(ticTacToe.startGame());
    }



    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare(o1[0], o2[0]);
            }
        });
        int curFirst = intervals[0][0];
        int curSecond = intervals[0][1];
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<intervals.length-1; i++){
            int nfirst = intervals[i+1][0];
            int nsecond = intervals[i+1][1];

            if(curSecond < nsecond && curSecond > nfirst){
                curSecond = nsecond;
            }
            else{
                list.add(List.of(curFirst, curSecond));
                curFirst = intervals[i][0];
                curSecond = intervals[i][1];
            }
        }

        int[][] ans = new int[list.size()][2];
        int i = 0;
        for (List<Integer> nestedList : list) {
                ans[i][0] = nestedList.get(0);
                ans[i][1] = nestedList.get(1);
                i++;
        }

        return ans;
    }
}
