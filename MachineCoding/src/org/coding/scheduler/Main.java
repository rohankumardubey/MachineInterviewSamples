package org.coding.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Job job1 = new Job("J1", 10, "p0", 10, "root");
    Job job2 = new Job("J2", 20, "p0", 40, "admin");
    Job job3 = new Job("J3", 15, "p2", 40, "root");
    Job job4 = new Job("J4", 30, "p1", 40, "user");
    Job job5 = new Job("J5", 10, "p2", 30, "user");
    List<Job> jobs = new ArrayList<>();
    jobs.add(job1);
    jobs.add(job2);
    jobs.add(job3);
    jobs.add(job4);
    jobs.add(job5);
    JobScheduler jobScheduler = new JobScheduler();
    jobScheduler.scheduleJob(jobs, "EDF", 2);
  }
}
