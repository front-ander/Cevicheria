package dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    void create(T entidad);

    T read(ID id);

    void update(T entidad);

    void delete(ID id);

    List<T> readAll();
}
