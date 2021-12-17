package controller.web.events;

import controller.commands.Command;
import controller.commands.CommandFactory;
import controller.constants.CommandCode;
import controller.web.RoverEndpoint;

public class RoverCommandEvent implements Event {
    CommandCode commandCode;
    int roverIndex;

    public RoverCommandEvent() {
        
    }

    public RoverCommandEvent(CommandCode commandCode, int roverIndex) {
        this.commandCode = commandCode;
        this.roverIndex = roverIndex;
    }

    @Override
    public void fire() {
        Command command = new CommandFactory().createCommand(commandCode);
        command.execute(RoverEndpoint.getEnvironment().getRovers().get(roverIndex));
    }

    
}
