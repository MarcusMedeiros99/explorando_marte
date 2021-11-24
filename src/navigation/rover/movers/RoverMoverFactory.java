package navigation.rover.movers;
import navigation.Direction;

public class RoverMoverFactory {
  
  public RoverMover createRoverMover(Direction direction) {
    switch (direction) {
      case NORTH:
        return new NorthRoverMover();
      case SOUTH:
        return new SouthRoverMover();
      case WEST:
        return new WestRoverMover();
      case EAST:
        return new EastRoverMover();
      default:
        throw new EnumConstantNotPresentException(Direction.class, "Invalid direction");
    }
  }
}
