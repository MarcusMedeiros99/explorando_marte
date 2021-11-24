package navigation.rover.movers;
import navigation.rover.Rover;

public class NorthRoverMover
implements RoverMover {

  @Override
  public void move(Rover rover) {
    rover.getWorld().flipPosition(rover.getPosition());
    rover.getPosition().goNorth();
    rover.getWorld().flipPosition(rover.getPosition());
  }
}
