package navigation.rover;
import navigation.Direction;
import navigation.Position;
import navigation.Rotation;
import navigation.rover.movers.RoverMover;
import navigation.rover.movers.RoverMoverFactory;
// import navigation.rover.rotators.RoverRotator;
// import navigation.rover.rotators.RoverRotatorFactory;
import navigation.world.World;

public class Rover {
  protected Position position;
  protected World world;
  protected Direction direction;

  public Rover(Position position, Direction direction, World world) {
    world.setPosition(position);
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

  public void setWorld(World world) {
      this.world = world;
  }

  public Direction getDirection() {
    return direction;
  }
  
  public void setDirection(Direction direction) {
      this.direction = direction;
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

  public void rotate(Rotation rotation) {
    switch (rotation) {
      case LEFT:
        rotateLeft();
        break;
      case RIGHT:
        rotateRight();
        break;
      default:
        break;
    }
  }
}
