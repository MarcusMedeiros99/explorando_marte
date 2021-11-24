package navigation.rover.rotators;
import navigation.rover.Rover;

public class RightRotator
implements RoverRotator {

  @Override
  public void rotate(Rover rover) {
    rover.rotateRight();
  }
}

