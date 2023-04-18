package org.apache.practise.pooling;

import java.util.Random;

public class ObjectPoolTest {
  public static void main(String[] args) throws InterruptedException {
    ObjectPool objectPool = new ObjectPool(2, 5, 10);
    final Object object = objectPool.getObject();
    final Object object1 = objectPool.getObject();
    final Object object2 = objectPool.getObject();
    final Object object3 = objectPool.getObject();
    System.out.println(objectPool.getObjectPoolNames());
    objectPool.releaseObject("name"+ new Random().nextInt(),object);
    objectPool.releaseObject("name"+ new Random().nextInt(),object1);
    objectPool.releaseObject("name"+ new Random().nextInt(),object2);
    objectPool.closePool();
//    objectPool.closePool();
  }
}
