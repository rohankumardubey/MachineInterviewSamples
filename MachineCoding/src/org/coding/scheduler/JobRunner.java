package org.coding.scheduler;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class JobRunner {
  abstract void runJob(List<Job> jobs, int numberOfThreads);

  protected Map<Integer, JobGroup> assignThreadsToJobs(int numberOfThreads, List<Job> jobs) {
    Map<Integer, JobGroup> threadToJobGroupMap = new LinkedHashMap<>();
    int counter = 0;
    for (Job job : jobs) {
      int key = counter%numberOfThreads;
      final JobGroup jobGroup =
          threadToJobGroupMap.getOrDefault(key, new JobGroup(key));
      jobGroup.addJob(job);
      threadToJobGroupMap.put(key, jobGroup);
      counter++;
    }
    return threadToJobGroupMap;
  }

  protected void displayScheduledJobs(Map<Integer, JobGroup> threadToJobGroupMap) {
    final Iterator<Map.Entry<Integer, JobGroup>> iterator =
        threadToJobGroupMap.entrySet().iterator();
    while(iterator.hasNext()) {
      final Map.Entry<Integer, JobGroup> next = iterator.next();
      System.out.print("Thread "+next.getKey() + "-");
      next.getValue().print();
      System.out.println();
    }
  }
}
