package com.vudrag.prefacalculator;

public class Score extends Party{

    private String playerOneScore;
    private String playerTwoScore;
    private String playerThreeScore;

    public Score(Party party, Integer instanceNumber) {
        super(party, instanceNumber);
    }

    public Score(Party party) {
        super(party);
    }

    public Score() {
    }

    public String getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(String playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public String getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(String playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public String getPlayerThreeScore() {
        return playerThreeScore;
    }

    public void setPlayerThreeScore(String playerThreeScore) {
        this.playerThreeScore = playerThreeScore;
    }
}
