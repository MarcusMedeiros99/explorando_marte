package navigation.world;
import navigation.Position;

public class World {
  protected Position topRightCorner;
  protected boolean[][] occupiedPositions;

  public World(Position topRightCorner) {
    this.topRightCorner = new Position(topRightCorner);
    this.occupiedPositions = 
      new boolean[topRightCorner.getX() + 1][topRightCorner.getY() + 1];
  }

  public Position getTopRightCorner() {
    return topRightCorner;
  }

  public boolean isPositionOccupied(Position position) {
    return occupiedPositions[position.getX()][position.getY()];
  }

  public boolean isXValid(int x) {
    return x >= 0  && x <= this.topRightCorner.getX();
  }

  public boolean isYValid(int y) {
    return y >= 0  && y <= this.topRightCorner.getY();
  } 

  public boolean isPositionInside(Position position) {
    return isXValid(position.getX()) && isYValid(position.getY());
  }

  public boolean isPositionValid(Position position) {
    return isPositionInside(position)
            && !isPositionOccupied(position);
  }

  public void flipPosition(Position position) {
    occupiedPositions[position.getX()][position.getY()] = 
      !occupiedPositions[position.getX()][position.getY()];
  }

}
