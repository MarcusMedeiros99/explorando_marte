package controller.web.events;

import navigation.Environment;


public class ConnectionEvent implements Event {
    @SuppressWarnings("unused")
    private Environment environment;

    public ConnectionEvent() {

    }

    public ConnectionEvent(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void fire() {

    }


}
