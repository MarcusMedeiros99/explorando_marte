package navigation;
import java.util.HashMap;

public enum Direction {
  EAST(0),
  NORTH(1),
  WEST(2),
  SOUTH(3),
  ;

  private final int directionCode;
  private static final HashMap<Integer, Direction> codeToDirection = 
    new HashMap<Integer, Direction>();


  static {
    for (Direction direction : Direction.values()) {
      codeToDirection.put(direction.getDirectionCode(), direction);
    }
  }

  private Direction(int directionCode) {
    this.directionCode = directionCode;
  }


  public int getDirectionCode() {
    return this.directionCode;
  }

  public Direction directionOnLeft() {
    int codeOfDirectionOnLeft = (this.directionCode + 1) % (Direction.values().length);
    
    return codeToDirection.get(
      codeOfDirectionOnLeft
    );
  }

  public Direction directionOnRight() {
    int codeOfDirectionOnRight = 
      (this.directionCode + Direction.values().length - 1) %
      (Direction.values().length);

    return codeToDirection.get(
      codeOfDirectionOnRight
    );
  }

}
