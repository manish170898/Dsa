package org.lld.conceptCoding.questions.TicTacToe.pieceInfo;

public enum PieceType {
    X("X"),
    O("O");
    private final String text;
    PieceType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
