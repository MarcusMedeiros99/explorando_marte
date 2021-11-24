package navigation;
public class Position {
  private int x;
  private int y;

  public Position() {
    this.x = 0;
    this.y = 0;
  }

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position(Position position) {
    this.x = position.x;
    this.y = position.y;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Position objPosition = (Position) obj;

    return x == objPosition.x &&
            y == objPosition.y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

}
