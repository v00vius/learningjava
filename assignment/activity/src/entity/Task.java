package entity;

import java.util.UUID;

public class Task {
private UUID id;
private String description;
// The status it the task: ToBeDone, InProgress, Done
private String status;
// 0-100%
private int progress;
// The time spent for the task, in hours
private int trackedTime;
private Person owner;

}
