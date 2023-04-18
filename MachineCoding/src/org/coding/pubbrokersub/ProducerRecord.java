package org.coding.pubbrokersub;

public class ProducerRecord<K,V> {
  private String topic;
  private K key;
  private V value;

  public ProducerRecord(String topic, K key, V value) {
    this.topic = topic;
    this.key = key;
    this.value = value;
  }

  public String getTopic() {
    return topic;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}
