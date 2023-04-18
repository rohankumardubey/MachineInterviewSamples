package org.coding.scheduler;

public class JobSchedulerFactory {
  public static JobRunner getJobRunner(String scheduler) {
    final SchedulerType schedulerType = SchedulerType.valueOf(scheduler);
    switch (schedulerType) {
      case SJF:
        return new SJFRunner();
      case EDF:
        return new EDFRunner();
      case FPS:
        return new FPSRunner();
      case FCFS:
        return new FCFSRunner();
      default:
        throw new RuntimeException("Invalid scheduler type");
    }
  }
}
