package controller.mappings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import navigation.Direction;

public class CharToDirection {
  private static CharToDirection instance;
  private static final Map<Character, Direction> mapping
    = initMapping();

  private static Map<Character, Direction> initMapping() {
    Map<Character, Direction> mapping = new HashMap<>();

    mapping.put('E', Direction.EAST);
    mapping.put('N', Direction.NORTH);
    mapping.put('W', Direction.WEST);
    mapping.put('S', Direction.SOUTH);

    return Collections.unmodifiableMap(mapping);
  }

  private CharToDirection() {

  }
  
  public static CharToDirection getInstance() {
    if (instance == null) {
      instance = new CharToDirection();
    }
    return instance;
  }

  public static Map<Character, Direction> getMapping() {
    return mapping;
  }

}
