package org.dk.animal;

import org.dk.action.Feedable;
import org.dk.action.LivingEntity;
import org.dk.action.Movable;
import org.dk.action.Reproducible;
import org.dk.environment.Position;

public abstract class Animals implements LivingEntity, Reproducible, Feedable, Movable {
    protected String name;
    protected int age;
    protected double energy;
    protected Position position;

    public Animals(String name, int age, Position position) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.energy = 100.0;
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

    @Override
    public double getEnergy() {
        return energy;
    }

    // Абстрактные методы, которые должны быть реализованы в подклассах
    public abstract void makeSound();

}
