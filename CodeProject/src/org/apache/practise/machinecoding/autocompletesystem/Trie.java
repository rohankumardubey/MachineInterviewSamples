package org.apache.practise.machinecoding.autocompletesystem;

public class Trie {
  private int numberOfTimes =-1;
  private Trie[] child;

  public boolean hasChid() {
    return null != child;
  }

  public void createChid() {
    this.child = new Trie[27];
  }

  public Trie[] getChild() {
    return child;
  }

  public void setNumberOfTimes(int numberOfTimes) {
    this.numberOfTimes = numberOfTimes;
  }

  public int getNumberOfTimes() {
    return this.numberOfTimes;
  }
}
