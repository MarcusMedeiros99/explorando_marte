package controller.commands;

import navigation.rover.Rover;

public class MoveForwardCommand
implements Command {

  @Override
  public void execute(Rover rover) {
    rover.moveForward();
  }
  
}
