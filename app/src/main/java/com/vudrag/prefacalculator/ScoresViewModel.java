package com.vudrag.prefacalculator;

import androidx.lifecycle.ViewModel;

public class ScoresViewModel extends ViewModel {

    private Score score;
    private Integer instanceNumber;
    private ScoresFragment fragment;

    public void setFragment(ScoresFragment fragment){
        this.fragment = fragment;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setNames(Party party, Integer instanceNumber){
        this.instanceNumber = instanceNumber;
        this.score = new Score(party, instanceNumber);
    }

    public void nextScreen(){
        addScores();
        if(instanceNumber == 2){
            showResult();
        }else{
            nextPlayer();
        }
    }

    private void addScores(){
        ResultSingleton.getInstance().addScores(score, instanceNumber);
    }

    private void nextPlayer(){
        fragment.openScoresFragment();
    }

    private void showResult(){
        fragment.openResultFragment();
    }
}