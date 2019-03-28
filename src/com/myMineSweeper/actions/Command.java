package com.myMineSweeper.actions;

import com.myMineSweeper.GameController;

public abstract class Command {

    protected GameController gameController;

    public Command(GameController gameController) {
        this.gameController = gameController;
    }

    public abstract void execute();
}
