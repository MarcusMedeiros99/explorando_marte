package navigation.rover.movers.validators;

import navigation.Position;

public class SouthMoveValidator 
implements MoveValidator {
  
  @Override
  public Position nextPosition(Position position) {
    Position nextPosition = new Position(position);
    nextPosition.goSouth();
    
    return nextPosition;
  }
  
}
  
