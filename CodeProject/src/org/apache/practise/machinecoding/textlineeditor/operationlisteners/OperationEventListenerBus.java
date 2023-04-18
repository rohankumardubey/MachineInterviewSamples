package org.apache.practise.machinecoding.textlineeditor.operationlisteners;

import java.util.HashMap;
import java.util.Map;

import org.apache.practise.machinecoding.textlineeditor.events.Event;

public class OperationEventListenerBus {

  private static final OperationEventListenerBus INSTANCE = new OperationEventListenerBus();

  private Map<String, OperationEventListener> listenerMap;

  private OperationEventListenerBus() {
    this.listenerMap = new HashMap<>();
  }

  public static OperationEventListenerBus getInstance() {
    return INSTANCE;
  }

  public void addListener(Class<? extends Event> eventClass, OperationEventListener operationEventListener) {
    this.listenerMap.putIfAbsent(eventClass.getName(), operationEventListener);
  }

  public void fireEvent(Event event) {
    listenerMap.get(event.getEventType()).onEvent(event);
  }
}
