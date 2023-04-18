package org.coding.json;

import java.util.ArrayList;
import java.util.List;

public class ConstructionDictVisitor implements DictionaryVisitior<Json> {
  private List<Tuple> tuples;
  private String lastKey = "";
  public ConstructionDictVisitor() {
    tuples = new ArrayList<>();
  }
  @Override public void visitKey(String key) {
    lastKey = key;
  }

  @Override public void visitValue(Json value) {
    tuples.add(new Tuple(lastKey, value));
  }

  @Override public Visitor<Json> visitValue() {
    return new ConstructionVisitor();
  }

  @Override public Json done() {
    return new DictJson(tuples);
  }
}
