package controller.commands;

import navigation.Rotation;
import navigation.rover.Rover;

public class RotateRightCommand
implements Command {

  @Override
  public void execute(Rover rover) {
    rover.rotate(Rotation.RIGHT);
    
  }
  
}
