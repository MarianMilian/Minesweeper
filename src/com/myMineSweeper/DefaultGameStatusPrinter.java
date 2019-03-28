package com.myMineSweeper;

public class DefaultGameStatusPrinter implements GameStatusPrinter {
    @Override
    public void printGameStatus(Game game) {
        System.out.println("Current lives:" + game.getLives());
    }
}
