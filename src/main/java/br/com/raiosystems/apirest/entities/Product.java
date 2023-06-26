package br.com.raiosystems.apirest.entities;

import java.util.UUID;

public class Product extends Item{
  private UUID id;
  private String type;
  private String name;
  private Double price;

  public Product() {
  }



  public Product(String name, Double price) {
    this.id = UUID.randomUUID();
    this.type = "Product";
    this.name = name;
    this.price = price;
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
