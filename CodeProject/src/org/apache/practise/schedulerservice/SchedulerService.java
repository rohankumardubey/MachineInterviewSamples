package org.apache.practise.schedulerservice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface SchedulerService {

  void schedule(Runnable runnable);

  void schedule(Runnable runnable, long delay, TimeUnit timeUnit);

  void schedule(Runnable runnable, long delay, int repetation, TimeUnit timeUnit);

  void schedule(Runnable runnable, Date date);

  void schedule(Runnable runnable, Date date, int repetation);

  void scheduleAtFixDelay(Runnable runnable, long delay, long period, TimeUnit timeUnit);

  void shutDown();

}
