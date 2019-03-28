package com.myMineSweeper.actions;

import com.myMineSweeper.GameController;

public class StartGameCommand extends Command {
    public StartGameCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        gameController.startGame();
    }
}
