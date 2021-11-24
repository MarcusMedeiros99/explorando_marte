package navigation.rover.rotators;
import navigation.Rotation;

public class RoverRotatorFactory {
  
  public RoverRotator createRoverRotator(Rotation rotation) {
    switch (rotation) {
      case LEFT:
        return new LeftRotator();
      case RIGHT:
        return new RightRotator();
      default:
        throw new EnumConstantNotPresentException(Rotation.class, "Invalid rotation");
    }
  }
}
