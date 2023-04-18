package org.coding.scheduler;

import java.util.ArrayList;
import java.util.List;

public class JobGroup implements Comparable<JobGroup> {
  private List<Job> jobList;
  private int totalExecutionTime;
  private int threadNumber;

  public JobGroup(int thredNumber) {
    this.jobList = new ArrayList<>();
    this.threadNumber = thredNumber;
  }

  public void addJob(Job job) {
    this.jobList.add(job);
    totalExecutionTime += job.getDuration();
  }

  public int getTotalExecutionTime() {
    return totalExecutionTime;
  }

  public void print() {
    for (Job job : jobList) {
      System.out.print(job.getJobName() + " ");
    }
    System.out.println();
  }

  @Override public int compareTo(JobGroup o) {
    if (totalExecutionTime == o.totalExecutionTime) {
      return threadNumber - o.threadNumber;
    }
    return totalExecutionTime - o.totalExecutionTime;
  }

  public int getThreadNumber() {
    return threadNumber;
  }
}
