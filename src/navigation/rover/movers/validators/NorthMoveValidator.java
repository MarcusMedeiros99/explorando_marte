package navigation.rover.movers.validators;

import navigation.Position;

public class NorthMoveValidator 
implements MoveValidator {
  
  @Override
  public Position nextPosition(Position position) {
    Position nextPosition = new Position(position);
    nextPosition.goNorth();
    
    return nextPosition;
  }

}
  
