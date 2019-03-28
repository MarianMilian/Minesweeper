package com.myMineSweeper.actions;

import com.myMineSweeper.GameController;

public class ShowHelpCommand extends Command {
    public ShowHelpCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public void execute() {
        System.out.println(" Available actions:");
        gameController.showAllCommands();


    }
}
