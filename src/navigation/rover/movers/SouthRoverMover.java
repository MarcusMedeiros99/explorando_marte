package navigation.rover.movers;
import navigation.rover.Rover;

public class SouthRoverMover
implements RoverMover {

  @Override
  public void move(Rover rover) {
    rover.getWorld().flipPosition(rover.getPosition());
    rover.getPosition().goSouth();
    rover.getWorld().flipPosition(rover.getPosition());
  }
}
