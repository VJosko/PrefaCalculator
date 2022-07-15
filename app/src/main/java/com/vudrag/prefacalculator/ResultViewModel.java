package com.vudrag.prefacalculator;

import androidx.lifecycle.ViewModel;

public class ResultViewModel extends ViewModel {

    private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setScoreBoard(Party party){
        score = new Score(party);
        setScores();
    }

    private void setScores(){
        ResultSingleton result = ResultSingleton.getInstance();
        score.setPlayerOneScore(String.valueOf(result.getPlayerOneScore()));
        score.setPlayerTwoScore(String.valueOf(result.getPlayerTwoScore()));
        score.setPlayerThreeScore(String.valueOf(result.getPlayerThreeScore()));
    }
}