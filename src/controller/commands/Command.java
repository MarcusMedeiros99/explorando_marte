package controller.commands;

import navigation.rover.Rover;

public interface Command {
  void execute(Rover rover);
}
