package com.myMineSweeper;

import java.io.Serializable;


public class GameData implements Serializable {
    private String userName;
    private Cell[][] gameField;
    private int lives;

    public GameData(){}
    public GameData(String userName, Cell[][] gameField,int lives) {
        this.userName = userName;
        this.gameField = gameField;
        this.lives=lives;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Cell[][] getGameField() {
        return gameField;
    }

    public void setGameField(Cell[][] gameField) {
        this.gameField = gameField;
    }
}
