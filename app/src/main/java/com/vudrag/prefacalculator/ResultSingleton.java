package com.vudrag.prefacalculator;

public class ResultSingleton {

    private static ResultSingleton instance;

    private ResultSingleton(){}

    public static ResultSingleton getInstance(){
        if(instance == null){
            instance = new ResultSingleton();
        }
        return instance;
    }


    private Integer playerOneScore;
    private Integer playerTwoScore;
    private Integer playerThreeScore;

    public Integer getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(Integer playerOneScore) {
        if(this.playerOneScore == null){
            this.playerOneScore = playerOneScore;
        }else{
            this.playerOneScore = getPlayerOneScore() + playerOneScore;
        }
    }

    public Integer getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(Integer playerTwoScore) {
        if(this.playerTwoScore == null){
            this.playerTwoScore = playerTwoScore;
        }else{
            this.playerTwoScore = getPlayerTwoScore() + playerTwoScore;
        }
    }

    public Integer getPlayerThreeScore() {
        return playerThreeScore;
    }

    public void setPlayerThreeScore(Integer playerThreeScore) {
        if(this.playerThreeScore == null){
            this.playerThreeScore = playerThreeScore;
        }else{
            this.playerThreeScore = getPlayerThreeScore() + playerThreeScore;
        }
    }

    public void addScores(Score score, Integer instanceNumber){
        Integer nPlayerScore = (Integer.parseInt(score.getPlayerTwoScore()) * -1);
        Integer nFirstOpponentScore = Integer.parseInt(score.getPlayerOneScore());
        Integer nSecondOpponentScore = Integer.parseInt(score.getPlayerThreeScore());
        switch (instanceNumber){
            case 0:
                setPlayerOneScore(
                        (nPlayerScore * 10) + nFirstOpponentScore + nSecondOpponentScore);
                setPlayerTwoScore(nSecondOpponentScore * -1);
                setPlayerThreeScore(nFirstOpponentScore * -1);
                break;
            case 1:
                setPlayerTwoScore(
                        (nPlayerScore * 10) + nFirstOpponentScore + nSecondOpponentScore);
                setPlayerOneScore(nFirstOpponentScore * -1);
                setPlayerThreeScore(nSecondOpponentScore * -1);
                break;
            case 2:
                setPlayerThreeScore(
                        (nPlayerScore * 10) + nFirstOpponentScore + nSecondOpponentScore);
                setPlayerOneScore(nSecondOpponentScore * -1);
                setPlayerTwoScore(nFirstOpponentScore * -1);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + instanceNumber);
        }
    }
}
