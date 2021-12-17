package controller.web;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import controller.web.events.ConnectionEvent;
import controller.web.messages.Message;
import controller.web.messages.decoders.MessageDecoder;
import controller.web.messages.encoders.MessageEncoder;
import navigation.Environment;
import jakarta.websocket.EncodeException;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.*;

@ServerEndpoint(
    value = "/rover",
    decoders = MessageDecoder.class,
    encoders = MessageEncoder.class
    )
public class RoverEndpoint {
    private Session session;
    private static Set<RoverEndpoint> roverEndpoints 
    = new CopyOnWriteArraySet<>();
    private static Environment environment;

    public static Environment getEnvironment() {
        return environment;
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        roverEndpoints.add(this);

        environment = (environment == null) ? new Environment() : environment;
        
        broadcast(new Message(new String("ConnectionEvent"), new ConnectionEvent(environment)));
    }

    @OnMessage
    public void onMessage(Message message) {
        message.getEvent().fire();
        broadcast(message);
    }

    @OnClose
    public void onClose() {
        roverEndpoints.remove(this);
    }

    private static void broadcast(Message message)  {

      roverEndpoints.forEach(endpoint -> {
          synchronized (endpoint) {
              try {
                  endpoint.session.getBasicRemote().
                    sendObject(message);
              } catch (IOException | EncodeException | IllegalStateException e) {
                  roverEndpoints.remove(endpoint);
                  System.err.println(message.getEventName() + " can't be sent to closed websocket");
              }
          }
      });
  }
}
