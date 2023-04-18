package org.apache.practise.machinecoding.autocompletesystem;

public class Node implements Comparable<Node> {
  private String data;
  private int numberOfTimes;

  public Node(String data, int numberOfTimes) {
    this.data = data;
    this.numberOfTimes = numberOfTimes;
  }

  @Override public int compareTo(Node o) {
    if (numberOfTimes > o.numberOfTimes) {
      return -1;
    } else if (o.numberOfTimes > numberOfTimes) {
      return 1;
    } else {
      return data.compareTo(o.data);
    }
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public int getNumberOfTimes() {
    return numberOfTimes;
  }

  public void setNumberOfTimes(int numberOfTimes) {
    this.numberOfTimes = numberOfTimes;
  }
}
