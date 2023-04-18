package org.coding.scheduler;

import java.util.List;

public class JobScheduler {
  public void scheduleJob(List<Job> jobList, String schedulerType, int numberOfThread) {
    final JobRunner jobRunner = JobSchedulerFactory.getJobRunner(schedulerType);
    jobRunner.runJob(jobList, numberOfThread);
  }
}
