package org.dk.action;

// Интерфейс для сущностей, которые могут питаться
public interface Feedable {
    void feed(LivingEntity food);
    double getEnergy();
}
