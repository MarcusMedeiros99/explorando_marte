package navigation.rover;
import navigation.Position;
import navigation.world.World;

public class Rover {
  protected Position position;
  protected World world;

  public Rover(Position position, World world) {
    this.world = world;
    this.position = position;

  }

  public Position getPosition() {
    return position;
  }

  public World getWorld() {
    return world;
  }

}
