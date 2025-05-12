package org.dk.action;

import org.dk.environment.Position;

// Базовый интерфейс для всех живых существ в симуляторе
public interface LivingEntity extends WorldSim {
    String getName();
    int getAge();
    void live();
    Position getPosition();
    void setPosition(Position position);
}
