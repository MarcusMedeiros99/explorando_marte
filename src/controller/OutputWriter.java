package controller;

import navigation.Environment;
import navigation.rover.Rover;

public class OutputWriter {
  static public void writeOutput(Environment environment) {
    for (Rover rover: environment.getRovers()) {
      System.out.print(rover.getPosition().getX());
      System.out.print(" ");
      System.out.print(rover.getPosition().getY());
      System.out.print(" ");
      System.out.println(rover.getDirection().name().charAt(0));
    }
  }
}
