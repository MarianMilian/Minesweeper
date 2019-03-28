package com.myMineSweeper;

import com.myMineSweeper.actions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.myMineSweeper.Game.FIELD_SIZE;

public class GameController {

    private final GameStorage gameStorage;
    private Map<String, Command> commands = new HashMap<>();
    private Game game;
    private String name;
    private String level;


    public GameController() {
        gameStorage = new GameStorage();
        DefaultGameStatusPrinter gameStatusPrinter = new DefaultGameStatusPrinter();

        commands.put("exit", new ExitCommand(this));
        commands.put("start game", new StartGameCommand(this));
        commands.put("help", new ShowHelpCommand(this));
        commands.put("chose cell", new ChoseCellCommand(this));
        commands.put("save", new SaveGameCommand(this, gameStorage));
        commands.put("restore",new RestoreGameCommand(this,gameStorage) );

        commands.put("status", new PrintGameStatusCommand(this, gameStatusPrinter));

    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("GameController have been  started");
        System.out.println("Enter your name:");
        name = sc.nextLine();

        do {
            System.out.println("Chose your level: Beginner , Medium, High");
            level = sc.nextLine();
        }
        while (!(level.equals("Beginner") | level.equals("Medium") | level.equals("High")));

        System.out.println("Your name is :" + name + ", your level is:" + level);

        this.game = new Game(name, level);
        this.game.start();

        showGameField();

    }

    public void play() {
        Scanner commandScanner = new Scanner(System.in);
        while (true) {
            System.out.println(" Please enter command... or help to get list of actions");
            String nextCommand = commandScanner.nextLine();
            Command command = commands.get(nextCommand);
            if (command != null) {
                command.execute();
            }
        }
    }


    public void showGameField() {
        Cell[][] gameField = game.getGameField();
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (j != FIELD_SIZE - 1) {
                    System.out.print(gameField[i][j] + " ");
                } else {
                    System.out.println(gameField[i][j] + " ");
                }
            }
        }

    }

    public void exit()  {
        if (name != null) {
            gameStorage.saveGame(getCurrentUser(), getGameData());
            System.out.println(" Game is  saved and exited");//TODO game  dose  not  saving there
            System.out.println(" Game is  ended");//TODO game  dose  not  saving there
            System.exit(0);
        } else {
            System.out.println(" Game exited");
            System.exit(0);
        }

    }

    public void showAllCommands() {
        System.out.println(commands.keySet());
    }

    public GameData getGameData() {
        return new GameData(getCurrentUser(), game.getGameField(),game.getLives());
    }
    public void setGameData(GameData gameData){
        game=new Game(gameData.getUserName(),gameData.getLives(),gameData.getGameField());
        showGameField();

    }
    public String getCurrentUser() {
        return game.getUserName();
    }

    public void choseCell() {
        Scanner sc = new Scanner(System.in);
        int row, colon;

        if (game.getLives() != 0) {
            System.out.println("Please chose  row of cell(0-9)");
            row = sc.nextInt();
            System.out.println("Please chose  colon of cell(0-9)");
            colon = sc.nextInt();
            game.checkCell(row, colon);

            showGameField();
        } else {
            System.out.println("Game Over");
        }
    }

    public Game getGame() {
        return this.game;
    }
}