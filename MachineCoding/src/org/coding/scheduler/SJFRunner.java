package org.coding.scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SJFRunner extends JobRunner {
  @Override public void runJob(List<Job> jobs, int numberOfThreads) {
    Collections.sort(jobs, new Comparator<Job>() {
      @Override public int compare(Job o1, Job o2) {
        if (o1.getDuration() == o2.getDuration()) {
          return o1.getPriority().ordinal() - o2.getPriority().ordinal();
        }
        return o1.getDuration() - o2.getDuration();
      }
    });
    final Map<Integer, JobGroup> integerJobGroupMap = assignThreadsToJobs(numberOfThreads, jobs);
    displayScheduledJobs(integerJobGroupMap);
  }
}
