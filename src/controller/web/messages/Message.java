package controller.web.messages;

import controller.web.events.Event;

public class Message{
    private String eventName;
    private Event event;
    
    public Message(String eventName, Event event) {
        this.eventName = eventName;
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
