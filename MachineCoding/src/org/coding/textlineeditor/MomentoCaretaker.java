package org.coding.textlineeditor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MomentoCaretaker {
  private Map<String, List<Momento>> map;

  public MomentoCaretaker() {
    this.map = new HashMap<>();
  }

  public void saveCheckpoint(String key, List<Momento> momentos) {
    map.put(key, momentos);
  }

  public List<Momento> getCheckpoint(String key) {
    return map.get(key);
  }
}
