package controller.mappings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import controller.constants.CommandCode;

public class CharToCommandCode {
  private static CharToCommandCode instance;
  private static final Map<Character, CommandCode> mapping
    = initMapping();

  private static Map<Character, CommandCode> initMapping() {
    Map<Character, CommandCode> mapping = new HashMap<>();

    mapping.put('M', CommandCode.MOVE_FORWARD);
    mapping.put('L', CommandCode.ROTATE_LEFT);
    mapping.put('R', CommandCode.ROTATE_RIGHT);

    return Collections.unmodifiableMap(mapping);
  }

  private CharToCommandCode() {

  }
  
  public static CharToCommandCode getInstance() {
    if (instance == null) {
      instance = new CharToCommandCode();
    }
    return instance;
  }

  public static Map<Character, CommandCode> getMapping() {
    return mapping;
  }

  public static CommandCode get(Character character) {
    return mapping.get(character);
  }

}
