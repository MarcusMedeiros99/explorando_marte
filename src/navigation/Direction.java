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

}
