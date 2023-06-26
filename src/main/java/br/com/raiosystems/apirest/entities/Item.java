package br.com.raiosystems.apirest.entities;

import java.util.UUID;

public class Item {
  private UUID id;
  private String name;
  private String type;

  public Item() {
  }

  public Item(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }



}
