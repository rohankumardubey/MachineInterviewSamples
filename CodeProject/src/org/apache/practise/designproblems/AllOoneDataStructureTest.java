package org.apache.practise.designproblems;

public class AllOoneDataStructureTest {
  public static void main(String[] args) {
    AllOOneDataStructure allOoneDataStructure = new AllOOneDataStructure();
    allOoneDataStructure.inc("vishal");
    allOoneDataStructure.inc("vishal");
//    allOoneDataStructure.inc("vikas");
//    allOoneDataStructure.inc("vikas");
    allOoneDataStructure.dec("vishal");
    allOoneDataStructure.dec("vishal");
    allOoneDataStructure.validate();
    //    allOoneDataStructure.inc("vishall");
//    allOoneDataStructure.inc("vikas");
//    allOoneDataStructure.inc("vikas");

//    System.out.println(allOoneDataStructure.getMaxKey());
//    System.out.println(allOoneDataStructure.getMinKey());
  }
}
