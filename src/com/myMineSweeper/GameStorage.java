package com.myMineSweeper;

import java.io.*;
import java.util.Scanner;

import static com.myMineSweeper.Game.FIELD_SIZE;

public class GameStorage implements Serializable {


    public GameData restoreGame(String userName) {


        return readGameDataFromFile(userName + ".txt");

    }

    private GameData readGameDataFromFile(String fileName) {
        GameData gameData = new GameData();
        String getLineOfField;
        char getCharFromString;
        try (Scanner gameFileScanner = new Scanner(new FileInputStream(fileName))) {
            gameData.setUserName(gameFileScanner.nextLine().trim());
            gameData.setLives(gameFileScanner.nextInt());

            Cell[][] gameField = new Cell[FIELD_SIZE][FIELD_SIZE];
            getLineOfField = gameFileScanner.nextLine();
            for (int i = 0; i < FIELD_SIZE; i++) {
                getLineOfField = gameFileScanner.nextLine();
               // System.out.println(getLineOfField);
                for (int j = 0; j < FIELD_SIZE; j++) {
                   getCharFromString = getLineOfField.charAt(j);
                   //System.out.println(getCharFromString);
                   //gameField[i][j].readCharFromFile(getCharFromString);
                   gameField[i][j]=restoreCell(getCharFromString);
                   //gameField[i][j].

                }
            }
            gameData.setGameField(gameField);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return gameData;
    }

    // * - not opened and not mined
    // # - not opened and mined
    // _ - opened and not mined
    // X - opened and mined
    private Cell restoreCell(char cellAsChar) {
        boolean isOpened = false;
        boolean isMined = false;

        if (cellAsChar=='_' || cellAsChar=='X') {
            isOpened = true;
        }
        if (cellAsChar=='#' || cellAsChar=='X') {
            isMined = true;
        }
        return new Cell(isMined, isOpened);
    }
    // private GameData

    public String getFileName() {
        File gamerFile;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please entering you name");
        String name = sc.nextLine();
        gamerFile = new File(name + ".txt");
        System.out.println("Game with name " + name + " exist :" + gamerFile.exists());
        return name;

    }

    public boolean saveGame(String userName, GameData gameData) {
        String userGameFileName = userName + ".txt";
        prepareFile(userGameFileName);
        return writeGameToFile(userGameFileName, gameData);
    }

    private boolean writeGameToFile(String fileName, GameData gameData) {
        Cell[][] gameField = gameData.getGameField();
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            printWriter.println(gameData.getUserName());
            printWriter.println(gameData.getLives());

            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField.length; j++) {
                    if (j != gameField.length - 1) {
                        printWriter.print(gameField[i][j].writeCharToFile());
                    } else {
                        printWriter.println(gameField[i][j].writeCharToFile());
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }


   /* private boolean writeGameToFile(String   fileName,GameData gameData) {
        Cell[][] gameField=gameData.getGameField();
        String userName = gameData.getUserName();
        int lives = gameData.getLives();

        try {
            FileOutputStream gameFile = new FileOutputStream(fileName);
          //  gameFile.write(gameData.getUserName());
            gameFile.write(gameData.getLives());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;

    }*/
    /*private boolean writeGameToFile(String fileName,GameData gameData) {

        ObjectOutputStream gameOutputStream= null;
        try {
            gameOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            gameOutputStream.writeObject(gameData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }*/

    private boolean prepareFile(String userGameFile) {
        Scanner sc = new Scanner(System.in);
        File file = new File(userGameFile);


        if (file.exists()) {
            String userInput;
            do {
                System.out.println("File exist, do  you  like  to  rewrite your file. ");
                System.out.println("YES/NO ");
                userInput = sc.nextLine();
            } while (!(userInput.equalsIgnoreCase("Yes") | userInput.equalsIgnoreCase("No")));

            if (userInput.equalsIgnoreCase("Yes")) {
                file.delete();
                try {
                    return file.createNewFile();
                } catch (IOException e) {
                    System.out.println();
                }
                System.out.println("File was created successful");
            } else {
                System.out.println("Game was not saved ");
            }
        } else {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                System.out.printf("File  [%s] cannot be created", userGameFile);
                e.printStackTrace();
            }
        }
        return false;
    }
}
