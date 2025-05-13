package org.dk.nature.animal;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dk.action.LivingEntity;
import org.dk.environment.Position;


@AllArgsConstructor
@SuperBuilder
public class PredatorDefault extends Predators{
    @Override
    public void makeSound() {

    }

    @Override
    public void feed(LivingEntity food) {

    }

    @Override
    public double getEnergy() {
        return 0;
    }

    @Override
    public void live() {
        System.out.println("I'm living!");
    }

    @Override
    public void setPosition(Position position) {

    }

    @Override
    public LivingEntity reproduce() {
        return null;
    }

    @Override
    public Position getPosition() {
        return null;
    }
}
