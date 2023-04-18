package org.coding.jsonnew.json;

import java.util.List;

public class DictionaryJson implements Json<List<Tuple>> {
  private List<Tuple> tuples;

  public DictionaryJson(List<Tuple> tuples) {
    this.tuples = tuples;
  }

  @Override public List<Tuple> getData() {
    return tuples;
  }
}
