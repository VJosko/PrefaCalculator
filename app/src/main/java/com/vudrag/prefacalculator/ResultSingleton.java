package com.vudrag.prefacalculator;

import java.util.Arrays;
import java.util.List;

public class ResultSingleton {

    private static ResultSingleton instance;

    private ResultSingleton() {
        isScoreAdded = Arrays.asList(false, false, false);
    }

    public static ResultSingleton getInstance() {
        if (instance == null) {
            instance = new ResultSingleton();
        }
        return instance;
    }

    private Score firstScore;
    private Score secondScore;
    private Score thirdScore;
    private Integer playerOneScore;
    private Integer playerTwoScore;
    private Integer playerThreeScore;
    private List<Boolean> isScoreAdded;

    public Score getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(Score firstScore) {
        this.firstScore = firstScore;
    }

    public Score getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(Score secondScore) {
        this.secondScore = secondScore;
    }

    public Score getThirdScore() {
        return thirdScore;
    }

    public void setThirdScore(Score thirdScore) {
        this.thirdScore = thirdScore;
    }

    public Integer getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(Integer playerOneScore) {
        if (this.playerOneScore == null) {
            this.playerOneScore = playerOneScore;
        } else {
            this.playerOneScore = getPlayerOneScore() + playerOneScore;
        }
    }

    public Integer getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(Integer playerTwoScore) {
        if (this.playerTwoScore == null) {
            this.playerTwoScore = playerTwoScore;
        } else {
            this.playerTwoScore = getPlayerTwoScore() + playerTwoScore;
        }
    }

    public Integer getPlayerThreeScore() {
        return playerThreeScore;
    }

    public void setPlayerThreeScore(Integer playerThreeScore) {
        if (this.playerThreeScore == null) {
            this.playerThreeScore = playerThreeScore;
        } else {
            this.playerThreeScore = getPlayerThreeScore() + playerThreeScore;
        }
    }


    public void addScores(Score score, Integer instanceNumber) {
        calculateNewScores(score, instanceNumber, true);
        isScoreAdded.set(instanceNumber, true);
    }

    public void removeScores(Score score, Integer instanceNumber) {
        if(Boolean.TRUE.equals(isScoreAdded.get(instanceNumber))) {
            calculateNewScores(score, instanceNumber, false);
            isScoreAdded.set(instanceNumber, false);
        }
    }

    private void calculateNewScores(Score score, Integer instanceNumber, boolean add) {
        Integer nPlayerScore = (score.getPlayerTwoIntegerScore() * -1);
        Integer nFirstOpponentScore = score.getPlayerOneIntegerScore();
        Integer nSecondOpponentScore = score.getPlayerThreeIntegerScore();
        if (!add) {
            nPlayerScore *= -1;
            nFirstOpponentScore *= -1;
            nSecondOpponentScore *= -1;
        }
        switch (instanceNumber) {
            case 0:
                setPlayerOneScore(
                        (nPlayerScore * 10) + nFirstOpponentScore + nSecondOpponentScore);
                setPlayerTwoScore(nSecondOpponentScore * -1);
                setPlayerThreeScore(nFirstOpponentScore * -1);
                break;
            case 1:
                setPlayerOneScore(nFirstOpponentScore * -1);
                setPlayerTwoScore(
                        (nPlayerScore * 10) + nFirstOpponentScore + nSecondOpponentScore);
                setPlayerThreeScore(nSecondOpponentScore * -1);
                break;
            case 2:
                setPlayerOneScore(nSecondOpponentScore * -1);
                setPlayerTwoScore(nFirstOpponentScore * -1);
                setPlayerThreeScore(
                        (nPlayerScore * 10) + nFirstOpponentScore + nSecondOpponentScore);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + instanceNumber);
        }
    }

}
