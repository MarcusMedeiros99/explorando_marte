package navigation;

import java.util.ArrayList;

import navigation.rover.Rover;
import navigation.world.World;

public class Environment {
  private World world;
  private ArrayList<Rover> rovers;

  public Environment() {
    this.rovers = new ArrayList<Rover>();
  }
  
  public Environment(Position topRightCorner) {
    this.rovers = new ArrayList<Rover>();
    this.world = new World(topRightCorner);
  }
  
  public ArrayList<Rover> getRovers() {
    return rovers;
  }

  public void setRovers(ArrayList<Rover> rovers) {
    this.rovers = rovers;
  }

  public World getWorld() {
    return world;
  }

  public void setWorld(World world) {
    this.world = world;
  }

  public Rover getLastRover() {
    return rovers.get(rovers.size() - 1);
  }

  public void addRover(Rover rover) {
    rovers.add(rover);
  }
}
