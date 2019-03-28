package com.myMineSweeper;

import java.io.Serializable;

public class Cell implements Serializable {
    private boolean isMined;
    private boolean isOpened;


    public Cell(boolean isMined, boolean isOpened) {
        this.isMined = isMined;
        this.isOpened = isOpened;
    }

    public boolean isMined() {
        return isMined;
    }

    public void setMined(boolean mined) {
        isMined = mined;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public String writeCharToFile() {
        String writeToFile;
        if (!isOpened && !isMined)
            return writeToFile = "*";
        else if (!isOpened && isMined)
            return writeToFile = "#";
        else if (isOpened && !isMined)
            return writeToFile = "_";
        else return writeToFile = "X";
    }

     void readCharFromFile(char charFromFile) {
        switch (charFromFile) {
            case '*':
                this.isOpened = false;
                this.isMined = false;
                System.out.println("Symbol are " +'*');
                break;
            case '#':
                this.isOpened = false;
                this.isMined = true;
                System.out.println("Symbol are " +'#');
                break;

            case 'X':
                this.isOpened = true;
                this.isMined = false;
                System.out.println("Symbol are " +'X');
                break;

            case '_':
                this.isOpened = true;
                this.isMined = false;
                System.out.println("Symbol are " +'_');
                break;
            default:
                System.out.println("Symbol are not Char");


        }
    }

    @Override
    public String toString() {
        String cellVisualRepresentation = "*";
        if (isOpened) {
            if (!isMined) {
                cellVisualRepresentation = "_";
            } else {
                cellVisualRepresentation = "X";
            }
        }
        return cellVisualRepresentation;
    }
}
