package navigation.rover.movers;

import navigation.rover.Rover;
import navigation.rover.movers.validators.MoveValidator;
import navigation.rover.movers.validators.EastMoveValidator;

public class EastRoverMover
implements RoverMover {

  @Override
  public void move(Rover rover) {
  MoveValidator eastMoveValidator = new EastMoveValidator();
    if (eastMoveValidator.validateMove(rover)) {
      rover.getWorld().flipPosition(rover.getPosition());
      rover.getPosition().goEast();
      rover.getWorld().flipPosition(rover.getPosition());
    }
  }
}
