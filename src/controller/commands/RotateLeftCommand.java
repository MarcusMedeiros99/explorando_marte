package controller.commands;

import navigation.Rotation;
import navigation.rover.Rover;

public class RotateLeftCommand 
implements Command {

  @Override
  public void execute(Rover rover) {
    rover.rotate(Rotation.LEFT);
    
  }
  
}
