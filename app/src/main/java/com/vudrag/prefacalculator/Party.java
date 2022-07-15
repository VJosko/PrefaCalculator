package com.vudrag.prefacalculator;

import android.content.Context;

import java.io.Serializable;

public class Party implements Serializable {

    private String playerOne;
    private String playerTwo;
    private String playerThree;

    public Party() {
    }

    public Party(Party party, Integer instanceNumber) {
        switch (instanceNumber){
            case 0:
                playerTwo = party.getPlayerOne();
                playerOne = party.getPlayerThree();
                playerThree = party.getPlayerTwo();
                break;
            case 1:
                playerTwo = party.getPlayerTwo();
                playerOne = party.getPlayerOne();
                playerThree = party.getPlayerThree();
                break;
            case 2:
                playerTwo = party.getPlayerThree();
                playerOne = party.getPlayerTwo();
                playerThree = party.getPlayerOne();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + instanceNumber);
        }
    }

    public Party(Party party) {
        playerOne = party.getPlayerOne();
        playerTwo = party.getPlayerTwo();
        playerThree = party.getPlayerThree();
    }

    public String getPlayerOne() {
        if(playerOne == null){
            return "";
        }
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        if(playerTwo == null){
            return "";
        }
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public String getPlayerThree() {
        if(playerThree == null){
            return "";
        }
        return playerThree;
    }

    public void setPlayerThree(String playerThree) {
        this.playerThree = playerThree;
    }

    public void fillEmptyNames(Context context){
        if(playerOne == null || playerOne.trim().isEmpty()){
            playerOne = context.getResources().getString(R.string.left_player);
        }
        if(playerTwo == null || playerTwo.trim().isEmpty()){
            playerTwo = context.getResources().getString(R.string.you);
        }
        if(playerThree == null || playerThree.trim().isEmpty()){
            playerThree = context.getResources().getString(R.string.right_player);
        }
    }
}
