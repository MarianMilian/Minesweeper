package com.myMineSweeper.actions;

import com.myMineSweeper.GameController;
import com.myMineSweeper.GameStorage;

public class SaveGameCommand extends Command {
    private GameStorage gameStorage;

    public SaveGameCommand(GameController gameController, GameStorage gameStorage) {
        super(gameController);
        this.gameStorage = gameStorage;
    }

    @Override
    public void execute() {
        gameStorage.saveGame(gameController.getCurrentUser(), gameController.getGameData());
    }
}
