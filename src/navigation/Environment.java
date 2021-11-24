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
}
