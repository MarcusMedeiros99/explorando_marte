package controller.commands;

import controller.constants.CommandCode;

public class CommandFactory {
  
  public Command createCommand(CommandCode commandCode) {
    switch (commandCode) {
      case MOVE_FORWARD:
        return new MoveForwardCommand();
      case ROTATE_LEFT:
        return new RotateLeftCommand();
      case ROTATE_RIGHT:
        return new RotateRightCommand();
      default:
        throw new EnumConstantNotPresentException(CommandCode.class, "Invalid Command");
    }
  }
}
