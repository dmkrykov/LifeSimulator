package org.dk.plant;

import org.dk.action.LivingEntity;
import org.dk.environment.Position;
import org.dk.action.Reproducible;

public abstract class Plants implements LivingEntity, Reproducible {
    protected String name;
    protected int age;
    protected Position position;
    protected double size;

    public Plants(String name, int age, Position position) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.size = 1.0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    // Абстрактные методы для растений
    public abstract void photosynthesize();
}
