package org.lld.conceptCoding.questions.TicTacToe.pieceInfo;

public class PieceO extends PlayingPiece {
    public PieceO() {
        super(PieceType.O);
    }

    @Override
    public String toString() {
        return PieceType.O.toString();
    }
}
