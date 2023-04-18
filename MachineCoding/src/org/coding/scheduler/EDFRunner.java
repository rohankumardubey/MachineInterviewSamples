package org.coding.scheduler;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class EDFRunner extends JobRunner {
  @Override public void runJob(List<Job> jobs, int numberOfThreads) {
    Collections.sort(jobs, new Comparator<Job>() {
      @Override public int compare(Job o1, Job o2) {
        if (o1.getDeadLine() == o2.getDeadLine()) {
          if (o1.getPriority() == o2.getPriority()) {
            return o1.getDuration() - o2.getDuration();
          } else {
            return o1.getPriority().ordinal() - o2.getPriority().ordinal();
          }

        }
        return o1.getDeadLine() - o2.getDeadLine();
      }
    });
    final Map<Integer, JobGroup> jobGroupMap = assignThreadsToJobs(numberOfThreads, jobs);
    displayScheduledJobs(jobGroupMap);
  }

  protected Map<Integer, JobGroup> assignThreadsToJobs(int numberOfThreads, List<Job> jobs) {
    PriorityQueue<JobGroup> jobGroups = new PriorityQueue<>();
    for (int i = 0; i < numberOfThreads; i++) {
      jobGroups.add(new JobGroup(i));
    }
    for (Job job : jobs) {
      final JobGroup poll = jobGroups.poll();
      if (poll.getTotalExecutionTime() + job.getDuration() <= job.getDeadLine()) {
        poll.addJob(job);
      }
      jobGroups.add(poll);
    }
    Map<Integer, JobGroup> jobGroupMap = new LinkedHashMap<>();
    while (!jobGroups.isEmpty()) {
      final JobGroup poll = jobGroups.poll();
      if(poll.getTotalExecutionTime()>0) {
        jobGroupMap.put(poll.getThreadNumber(), poll);
      }
    }
    return jobGroupMap;
  }
}
