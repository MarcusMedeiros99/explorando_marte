package controller.web.events;

import java.util.ArrayList;

import controller.web.RoverEndpoint;
import navigation.Position;
import navigation.world.World;

public class NewWorldEvent implements Event {
    private Position topRightCorner;
    
    public NewWorldEvent() {
        
    }

    public NewWorldEvent(Position topRightCorner) {
        this.topRightCorner = topRightCorner;
    }

    @Override
    public void fire() {
        RoverEndpoint.getEnvironment().setWorld(new World(topRightCorner));
        RoverEndpoint.getEnvironment().setRovers(new ArrayList<>());
    }

    
}
