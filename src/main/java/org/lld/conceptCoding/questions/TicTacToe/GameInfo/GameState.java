package org.lld.conceptCoding.questions.TicTacToe.GameInfo;

public enum GameState {
    TIE("TIE"),
    PLAYING("PLAYING"),
    ENDED("ENDED"),
    INITIALIZED("INITIALIZED");

    private final String text;
    GameState(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
