package org.coding.scheduler;

public class Job {
  private String jobName;
  private int duration;
  private JobPriority priority;
  private int deadLine;
  private UserType userType;

  public Job(String jobName, int duration, String priority, int deadLine,
      String userType) {
    this.jobName = jobName;
    this.duration = duration;
    this.priority = JobPriority.valueOf(priority.toUpperCase());
    this.deadLine = deadLine;
    this.userType = UserType.valueOf(userType.toUpperCase());
  }

  public String getJobName() {
    return jobName;
  }

  public int getDuration() {
    return duration;
  }

  public JobPriority getPriority() {
    return priority;
  }

  public int getDeadLine() {
    return deadLine;
  }

  public UserType getUserType() {
    return userType;
  }
}
