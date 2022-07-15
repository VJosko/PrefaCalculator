package com.vudrag.prefacalculator;

import java.util.HashSet;
import java.util.Set;

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

    public Integer getPlayerOneIntegerScore(){
        return getIntegerScore(getPlayerOneScore());
    }

    public Integer getPlayerTwoIntegerScore(){
        return getIntegerScore(getPlayerTwoScore());
    }

    public Integer getPlayerThreeIntegerScore(){
        return getIntegerScore(getPlayerThreeScore());
    }

    private Integer getIntegerScore(String playerScore){
        try {
            return Integer.parseInt(playerScore);
        }catch (NumberFormatException ex){
            return 0;
        }
    }
}
