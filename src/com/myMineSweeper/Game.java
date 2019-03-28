package com.myMineSweeper;

public class Game {
    public static final int FIELD_SIZE = 10;
    public final float BEGINNER = 0.1f;
    public final float MEDIUM = 0.25f;
    public final float HIGH = 0.5f;

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentLevel(float currentLevel) {
        this.currentLevel = currentLevel;
    }

    private int lives = 3;

    public void setGameField(Cell[][] gameField) {
        this.gameField = gameField;
    }

    public Cell[][] gameField = new Cell[FIELD_SIZE][FIELD_SIZE];//  як тут   працює?
    private String name;
    private String level;
    private float currentLevel;   // todo something is wrong there

    public Game(String name, String level) {
        this.name = name;
        this.level = level;
        setLevel(this.level);

    }
    public Game(String name,int lives,Cell[][]gameFieldFromFile){
        this.name=name;
        setLives(lives);
        this.gameField=gameFieldFromFile;
        //setGameField(gameFieldFromFile);


    }
    public void checkCell(int row, int colon) {
        gameField[row][colon].setOpened(true);
        if (gameField[row][colon].isMined()) {
            lives--;
            System.out.println("Mine was mined you have " + lives + " lives");
        }

    }

    public void createFields(float probabilityOfMineOnCell) {

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                gameField[i][j] = new Cell(Math.random() < probabilityOfMineOnCell, false);
            }
        }
    }

    public Cell[][] getGameField() {
        return gameField;
    }

    public int getLives() {
        return lives;
    }

    public void start() {
        createFields(currentLevel);
    }

    public String getUserName() {
        return name;
    }

    public void setLevel(String level) {
        switch (level) {
            case "Beginner":
                currentLevel = BEGINNER;
                break;
            case "Medium":
                currentLevel = MEDIUM;
                break;
            case "High":
                currentLevel = HIGH;
                break;
        }
    }
}

