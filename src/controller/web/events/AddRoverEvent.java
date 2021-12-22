package controller.web.events;

import controller.web.RoverEndpoint;
import navigation.Direction;
import navigation.rover.Rover;

public class AddRoverEvent implements Event {
    private Rover rover;

    public AddRoverEvent() {
        
    }

    public AddRoverEvent(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void fire() {
        rover.setDirection(Direction.NORTH);
        rover.setWorld(RoverEndpoint.getEnvironment().getWorld());
        RoverEndpoint.getEnvironment().addRover(rover);
        RoverEndpoint.getEnvironment().getWorld().setPosition(rover.getPosition());
    }

}
