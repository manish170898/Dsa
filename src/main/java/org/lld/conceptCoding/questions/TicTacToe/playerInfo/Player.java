package org.lld.conceptCoding.questions.TicTacToe.playerInfo;

import org.lld.conceptCoding.questions.TicTacToe.pieceInfo.PlayingPiece;

public class Player {
    private final String name;
    private final PlayingPiece pieceType;
    public Player(String name, PlayingPiece pieceType) {
        this.name = name;
        this.pieceType = pieceType;
    }
    public String getName() {
        return name;
    }
    public PlayingPiece getPieceType() {
        return pieceType;
    }
}
