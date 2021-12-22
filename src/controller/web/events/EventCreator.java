package controller.web.events;


public class EventCreator {
    String eventName;

    public EventCreator(String eventName) {
        this.eventName = eventName;
    }

    public Event create() throws IllegalArgumentException {
        if (eventName.equals(new String("NewWorldEvent"))) return new NewWorldEvent();
        else if (eventName.equals(new String("RoverCommandEvent"))) return new RoverCommandEvent();
        else if (eventName.equals(new String("ConnectionEvent"))) return new ConnectionEvent();
        else if (eventName.equals(new String("AddRoverEvent"))) return new AddRoverEvent();
        else if (eventName.equals(new String("UpdateEvent"))) return new UpdateEvent();
        else throw new IllegalArgumentException("No such event name: " + eventName);
    }
}
