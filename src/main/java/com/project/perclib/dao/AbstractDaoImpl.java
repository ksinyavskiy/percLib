package com.project.perclib.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public abstract class AbstractDaoImpl<E, T extends Serializable> implements AbstractDao<E, T> {
    private final SessionFactory sessionFactory;
    protected Class<E> entityClass =
            (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public Optional<E> getEntityById(T entityId) {
        E entity = getSession().get(entityClass, entityId);
        return Optional.ofNullable(entity);
    }

    @Override
    public void saveEntity(E entity) {
        getSession().persist(entity);
    }

    @Override
    public void updateEntity(E entity) {
        getSession().merge(entity);
    }

    @Override
    public void deleteEntity(E entity) {
        getSession().delete(entity);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
