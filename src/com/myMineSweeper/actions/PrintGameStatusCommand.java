package com.myMineSweeper.actions;

import com.myMineSweeper.GameController;
import com.myMineSweeper.GameStatusPrinter;

public class PrintGameStatusCommand extends Command {
    private GameStatusPrinter gameStatusPrinter;

    public PrintGameStatusCommand(GameController gameController, GameStatusPrinter gameStatusPrinter) {
        super(gameController);
        this.gameStatusPrinter = gameStatusPrinter;
    }

    @Override
    public void execute() {
        this.gameStatusPrinter.printGameStatus(gameController.getGame());
    }
}
