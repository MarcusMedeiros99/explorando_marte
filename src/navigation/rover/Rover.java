package navigation.rover;
import navigation.Direction;
import navigation.Position;
import navigation.rover.movers.RoverMover;
import navigation.rover.movers.RoverMoverFactory;
import navigation.world.World;

public class Rover {
  protected Position position;
  protected World world;
  protected Direction direction;

  public Rover(Position position, Direction direction, World world) {
    this.world = world;
    this.position = position;
    this.direction = direction;
  }

  public Position getPosition() {
    return position;
  }

  public World getWorld() {
    return world;
  }

  public Direction getDirection() {
    return direction;
  }

  public void rotateLeft() {
    this.direction = direction.directionOnLeft();
  }

  public void rotateRight() {
    this.direction = direction.directionOnRight();
  }

  public void moveForward() {
    RoverMoverFactory roverMoverFactory = new RoverMoverFactory();
    RoverMover roverMover = roverMoverFactory.createRoverMover(this.direction);
    roverMover.move(this);
  }
}
