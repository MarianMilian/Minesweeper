package com.myMineSweeper.actions;

import com.myMineSweeper.GameController;
import com.myMineSweeper.GameStorage;

public class RestoreGameCommand extends Command {
    private GameStorage gameStorage;

    public RestoreGameCommand(GameController gameController, GameStorage gameStorage) {
        super(gameController);
        this.gameStorage = gameStorage;
    }

    @Override
    public void execute() {
        gameController.setGameData(gameStorage.restoreGame(gameStorage.getFileName()));

    }
}
