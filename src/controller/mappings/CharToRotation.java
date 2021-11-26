package controller.mappings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import navigation.Rotation;

public class CharToRotation {
  private static CharToRotation instance;
  private static final Map<Character, Rotation> mapping
    = initMapping();

  private static Map<Character, Rotation> initMapping() {
    Map<Character, Rotation> mapping = new HashMap<>();

    mapping.put('L', Rotation.LEFT);
    mapping.put('R', Rotation.RIGHT);

    return Collections.unmodifiableMap(mapping);
  }

  private CharToRotation() {

  }
  
  public static CharToRotation getInstance() {
    if (instance == null) {
      instance = new CharToRotation();
    }
    return instance;
  }

  public static Map<Character, Rotation> getMapping() {
    return mapping;
  }

  public static Rotation get(Character character) {
    return mapping.get(character);
  }

}
