package org.apache.practise.pooling;

public class ObjectPoolTest {
  public static void main(String[] args) throws InterruptedException {
    ObjectPool objectPool = new ObjectPool(2, 5, 10);
    final Object object = objectPool.getObject();
    final Object object1 = objectPool.getObject();
    final Object object2 = objectPool.getObject();
    final Object object3 = objectPool.getObject();
    objectPool.releaseObject(object);
    objectPool.releaseObject(object1);
    objectPool.releaseObject(object2);
//    objectPool.closePool();
  }
}
