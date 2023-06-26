package br.com.raiosystems.apirest.repositories;

import java.util.List;
import java.util.UUID;

public interface IRepository<T> {
  public T findByName(String name);

  public T findById(UUID id);

  public List<T> getAll();

  public T save(T data);
}
