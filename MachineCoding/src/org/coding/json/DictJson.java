package org.coding.json;

import java.util.List;

public class DictJson implements Json<List<Tuple>> {
  private List<Tuple> tuple;

  public DictJson(List<Tuple> tuple) {
    this.tuple = tuple;
  }

  @Override public List<Tuple> getData() {
    return tuple;
  }
}
