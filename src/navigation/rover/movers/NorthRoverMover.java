package navigation.rover.movers;
import navigation.rover.Rover;
import navigation.rover.movers.validators.MoveValidator;
import navigation.rover.movers.validators.NorthMoveValidator;

public class NorthRoverMover
implements RoverMover {

  @Override
  public void move(Rover rover) {
    MoveValidator northMoveValidator = new NorthMoveValidator();
    if (northMoveValidator.validateMove(rover)) {
      rover.getWorld().flipPosition(rover.getPosition());
      rover.getPosition().goNorth();
      rover.getWorld().flipPosition(rover.getPosition());
    }
  }
}
