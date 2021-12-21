package controller.web.events;

import controller.commands.Command;
import controller.commands.CommandFactory;
import controller.constants.CommandCode;
import controller.web.RoverEndpoint;
import navigation.rover.Rover;

public class RoverCommandEvent implements Event {
    CommandCode commandCode;
    int roverIndex;
    Rover rover;

    public RoverCommandEvent() {
        
    }

    public RoverCommandEvent(CommandCode commandCode, int roverIndex) {
        this.commandCode = commandCode;
        this.roverIndex = roverIndex;    
    }

    @Override
    public void fire() {
        this.rover = RoverEndpoint.getEnvironment().getRovers().get(roverIndex);
        Command command = new CommandFactory().createCommand(commandCode);
        command.execute(this.rover);
    }

    
}
