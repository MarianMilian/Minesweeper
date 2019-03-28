package com.myMineSweeper.actions;

import com.myMineSweeper.GameController;

public class ExitCommand extends Command {
    public ExitCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        gameController.exit();
    }
}
