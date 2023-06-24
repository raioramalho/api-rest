package br.com.raiosystems.apirest.entities;

import java.util.UUID;

public class Product {
  private UUID id;
  private String name;
  private Double price;

  public Product() {
  }



  public Product(UUID id, String name, Double price) {
    this.id = UUID.randomUUID();
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



}
