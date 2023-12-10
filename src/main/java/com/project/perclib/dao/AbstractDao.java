package com.project.perclib.dao;

import java.io.Serializable;
import java.util.Optional;

public interface AbstractDao<E, T extends Serializable> {
    Optional<E> getEntityById(T entityId);

    void saveEntity(E entity);

    void updateEntity(E entity);

    void deleteEntity(E entity);
}
