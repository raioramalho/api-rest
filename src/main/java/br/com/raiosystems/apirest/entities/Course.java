package br.com.raiosystems.apirest.entities;

import java.util.UUID;

public class Course {
  private UUID id;
  private String description;
  private String name;
  private int workload;

  public Course() {
  }

  public Course(String description, String name, int workload) {
    this.id = new UUID(1L, 0);
    this.description = description;
    this.name = name;
    this.workload = workload;
  }

  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getWorkload() {
    return workload;
  }
  public void setWorkload(int workload) {
    this.workload = workload;
  }


}
