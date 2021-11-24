package navigation.rover.movers.validators;

import navigation.Position;
import navigation.rover.Rover;

public interface MoveValidator {
  default boolean validateMove(Rover rover) {
    return rover.getWorld().isPositionValid(nextPosition(rover.getPosition()));
  }

  Position nextPosition(Position position);
}
