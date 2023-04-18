package org.coding.schedulerservice;

import java.util.concurrent.TimeUnit;

public class SchedulerServiceTest {
  public static void main(String[] args) {
    SchedulerService schedulerService = new SchedulerService(10);
//    schedulerService.schedule(new Runnable() {
//      @Override public void run() {
//        System.out.println("i am here");
//      }
//    }, 10000, TimeUnit.MILLISECONDS);
    ////
        schedulerService.schedule(new Runnable() {
          @Override public void run() {
            System.out.println(System.currentTimeMillis());
            System.out.println("i am here repetation");
          }
        }, 10000,5,  TimeUnit.MILLISECONDS);
        try {
          Thread.sleep(10000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
//    try {
//      System.out.println("I  m waiting");
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    schedulerService.schedule(new Runnable() {
//      @Override public void run() {
//        System.out.println("i am here single one");
//      }
//    });

    //    try {
    //      Thread.sleep(1000);
    //    } catch (InterruptedException e) {
    //      e.printStackTrace();
    //    }
//        schedulerService.schedule(new Runnable() {
//          @Override public void run() {
//            System.out.println("i am here single one");
//          }
//        });

    //    schedulerService.shutDown();
  }
}
