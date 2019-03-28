package com.myMineSweeper.actions;

import com.myMineSweeper.GameController;

public class ChoseCellCommand extends Command {
    public ChoseCellCommand(GameController gameController){
       super(gameController);
    }

    @Override
    public void execute() {
        gameController.choseCell();
    }
}
