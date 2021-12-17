package controller.web.messages.decoders;

import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import controller.web.events.Event;
import controller.web.events.EventCreator;
import controller.web.messages.Message;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;

public class MessageDecoder implements Decoder.Text<Message> {

    private static Gson gson = new Gson();


    @Override
    public Message decode(String s) throws DecodeException {
        StringReader stringReader = new StringReader(s);
        JsonReader jsonReader = new JsonReader(stringReader);
        String eventName;
        Event event;

        JsonElement jsonElement = JsonParser.parseReader(jsonReader);
        eventName = jsonElement.getAsJsonObject().get("eventName").toString();
        
        String eventAsString = jsonElement.getAsJsonObject().get("event").toString();
        eventName = new String(eventName).substring(1, eventName.length() - 1);
        
        event = new EventCreator(eventName).create();
        event = gson.fromJson(eventAsString, event.getClass());

        Message message = new Message(eventName, event);

        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

}