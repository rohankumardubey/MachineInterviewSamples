package org.coding.scheduler;

import java.util.List;
import java.util.Map;

public class FCFSRunner extends JobRunner {
  @Override public void runJob(List<Job> jobs, int numberOfThreads) {
    final Map<Integer, JobGroup> integerJobGroupMap = assignThreadsToJobs(numberOfThreads, jobs);
    displayScheduledJobs(integerJobGroupMap);
  }
}
