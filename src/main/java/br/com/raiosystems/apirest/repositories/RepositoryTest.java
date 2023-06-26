package br.com.raiosystems.apirest.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.raiosystems.apirest.entities.Item;

public class RepositoryTest<T extends Item> implements IRepository<T> {
  private List<T> db;

  public RepositoryTest() {
    this.db = new ArrayList<T>();
  }

  @Override
  public List<T> getAll() {
    return db;
  }

  @Override
  public T findByName(String name) {
    Optional<T> T = this.db.stream().filter(db -> db.getName().equals(name)).findFirst();
    return T.orElse(null);
  }

  @Override
  public T findById(UUID id) {
    Optional<T> T = this.db.stream().filter(db -> db.getId().equals(id)).findFirst();
    return T.orElse(null);
  }

  @Override
  public T save(T data) {
    data.setId(UUID.randomUUID());
    this.db.add(data);
    return data;
  }

}
