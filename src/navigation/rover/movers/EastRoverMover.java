package navigation.rover.movers;

import navigation.rover.Rover;

public class EastRoverMover
implements RoverMover {

  @Override
  public void move(Rover rover) {
    rover.getWorld().flipPosition(rover.getPosition());
    rover.getPosition().goEast();
    rover.getWorld().flipPosition(rover.getPosition());
  }
}
