package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import navigation.Direction;
import navigation.Environment;
import navigation.Position;
import navigation.rover.Rover;
import navigation.world.World;
import controller.commands.Command;
import controller.commands.CommandFactory;
import controller.constants.CommandCode;
import controller.mappings.CharToCommandCode;
import controller.mappings.CharToDirection;

public class InputReader {
  private static File file;
  private static Scanner reader;
  private static Environment environment;

  private static void setFileReader(String path) throws FileNotFoundException {
    file = new File(path);
    reader = new Scanner(file);
    environment = new Environment();
  }

  private static Position readPositionFromFile() {
    Position position = new Position();

    position.setX(reader.nextInt());
    position.setY(reader.nextInt());

    return position;
  }

  private static void readWorldFromFile() {
    Position topRightCorner = readPositionFromFile();
    environment.setWorld(new World(topRightCorner)); 
  }

  private static void readRoverFromFile() {
    Position initialPosition = readPositionFromFile();

    Direction direction = CharToDirection
                            .getMapping()
                            .get(reader.next().charAt(0));

    Rover rover = new Rover(initialPosition, direction, environment.getWorld());
    environment.getRovers().add(rover);
  }

  private static void readRoverCommandsFromFile() {
    String roverMoves = reader.next();

    for (char move : roverMoves.toCharArray()) {
      CommandCode commandCode = CharToCommandCode.getMapping().get(move);
      Command command = new CommandFactory().createCommand(commandCode);

      command.execute(environment.getRovers().get(environment.getRovers().size() - 1));
    }
  }

  private static void readRoversFromFile() {
    while (reader.hasNextLine()) {
      readRoverFromFile();
      readRoverCommandsFromFile();
    }
  }
  
  static public Environment parseFile(String path) throws FileNotFoundException {
    setFileReader(path);
    readWorldFromFile();
    readRoversFromFile();

    reader.close();

    return environment;
  }
}
