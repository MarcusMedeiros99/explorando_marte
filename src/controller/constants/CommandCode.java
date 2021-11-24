package controller.constants;

public enum CommandCode {
  MOVE_FORWARD('M'),
  ROTATE_LEFT('L'),
  ROTATE_RIGHT('R');

  private final char commandCode;

  private CommandCode(char commandCode ) {
    this.commandCode = commandCode;
  }

  public char getCommandCode() {
    return commandCode;
  }

}
