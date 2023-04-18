package org.apache.practise.machinecoding.textlineeditor.storage.checkpoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckPointCareTaker {
  private Map<String, List<Momento>> savePointStorage;

  public CheckPointCareTaker() {
    this.savePointStorage = new HashMap<>();
  }

  public void saveCheckPoint(String checkpointName, List<Momento> momentos) {
    this.savePointStorage.put(checkpointName, momentos);
  }

  public List<Momento> getCheckPoint(String checkpointName) {
    return this.savePointStorage.remove(checkpointName);
  }
}
