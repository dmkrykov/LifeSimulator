package org.dk.action;


// Интерфейс для сущностей, которые могут питаться
public interface Feedable<T> {
    void feed(T entity);

}
