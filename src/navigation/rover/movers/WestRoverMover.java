package navigation.rover.movers;
import navigation.rover.Rover;

public class WestRoverMover
implements RoverMover {

  @Override
  public void move(Rover rover) {
    rover.getWorld().flipPosition(rover.getPosition());
    rover.getPosition().goWest();
    rover.getWorld().flipPosition(rover.getPosition());
  }
}

