package controller.web.events;

import java.util.ArrayList;

import controller.web.RoverEndpoint;
import navigation.rover.Rover;

public class UpdateEvent implements Event {
    @SuppressWarnings("unused")
    private ArrayList<Rover> rovers;

    public UpdateEvent() {
        this.rovers = RoverEndpoint.getEnvironment().getRovers();
    }

    @Override
    public void fire() {
        
    }

    

}
