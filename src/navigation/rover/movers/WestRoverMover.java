package navigation.rover.movers;
import navigation.rover.Rover;
import navigation.rover.movers.validators.MoveValidator;
import navigation.rover.movers.validators.WestMoveValidator;

public class WestRoverMover
implements RoverMover {

  @Override
  public void move(Rover rover) {
    MoveValidator westMoveValidator = new WestMoveValidator();
    if (westMoveValidator.validateMove(rover)) {
      rover.getWorld().flipPosition(rover.getPosition());
      rover.getPosition().goWest();
      rover.getWorld().flipPosition(rover.getPosition());
    }
      
  }
}

