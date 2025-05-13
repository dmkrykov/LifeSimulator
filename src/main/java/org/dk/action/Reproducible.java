package org.dk.action;

// Интерфейс для сущностей, которые могут размножаться
@FunctionalInterface
public interface Reproducible {
    LivingEntity reproduce();
}
