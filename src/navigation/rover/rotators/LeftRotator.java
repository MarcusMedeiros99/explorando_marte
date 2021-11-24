package navigation.rover.rotators;
import navigation.rover.Rover;

public class LeftRotator
implements RoverRotator {

  @Override
  public void rotate(Rover rover) {
    rover.rotateLeft();
  }
}
