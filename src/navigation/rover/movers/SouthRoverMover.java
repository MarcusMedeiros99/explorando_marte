package navigation.rover.movers;
import navigation.rover.Rover;
import navigation.rover.movers.validators.MoveValidator;
import navigation.rover.movers.validators.SouthMoveValidator;

public class SouthRoverMover
implements RoverMover {

  @Override
  public void move(Rover rover) {
    MoveValidator southMoveValidator = new SouthMoveValidator();
    if (southMoveValidator.validateMove(rover)) {
      rover.getWorld().flipPosition(rover.getPosition());
      rover.getPosition().goSouth();
      rover.getWorld().flipPosition(rover.getPosition());
    }
  }
}
