package org.uber.schedulerservice;

import java.util.concurrent.TimeUnit;

public interface SchedulerService {

  void submit(Runnable task);
  void submit(Runnable task, long delay, TimeUnit timeUnit);
  void submit(Runnable task, long delay, long repetation, TimeUnit timeUnit);
  void shutdown();

}
