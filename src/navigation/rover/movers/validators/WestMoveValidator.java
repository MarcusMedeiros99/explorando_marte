package navigation.rover.movers.validators;

import navigation.Position;

public class WestMoveValidator 
implements MoveValidator {
  
  @Override
  public Position nextPosition(Position position) {
    Position nextPosition = new Position(position);
    nextPosition.goWest();
    
    return nextPosition;
  }
  
}
  
