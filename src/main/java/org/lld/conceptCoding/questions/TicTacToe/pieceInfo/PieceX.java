package org.lld.conceptCoding.questions.TicTacToe.pieceInfo;

public class PieceX extends PlayingPiece {
    public PieceX() {
        super(PieceType.X);
    }

    @Override
    public String toString() {
        return PieceType.X.toString();
    }
}
