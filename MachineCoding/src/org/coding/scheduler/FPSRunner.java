package org.coding.scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class FPSRunner extends JobRunner {
  @Override public void runJob(List<Job> jobs, int numberOfThreads) {
    Collections.sort(jobs, new Comparator<Job>() {
      @Override public int compare(Job o1, Job o2) {
        if (o1.getPriority().ordinal() == o2.getPriority().ordinal()) {
          if (o1.getUserType().ordinal() == o2.getUserType().ordinal()) {
            return o1.getDuration() - o2.getDuration();
          } else {
            return o1.getUserType().ordinal() - o2.getUserType().ordinal();
          }
        } else {
          return o1.getPriority().ordinal() - o2.getPriority().ordinal();
        }
      }
    });
    final Map<Integer, JobGroup> integerJobGroupMap = assignThreadsToJobs(numberOfThreads, jobs);
    displayScheduledJobs(integerJobGroupMap);
  }
}
