package org.dk.action;

import org.dk.environment.Position;

// Базовый интерфейс для всех живых существ в симуляторе
public interface LivingEntity extends WorldSim {
    int getAge();
    String getIcon();
    void live();

    void setPosition(Position position);
}
