package org.dk.nature.animal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dk.action.LivingEntity;
import org.dk.environment.Position;
import org.dk.loaders.Entity;


@AllArgsConstructor
@ToString(callSuper = true)
public class PredatorDefault extends Predators{
    public PredatorDefault(Entity entity) {
        name = entity.getName();
        age = (int) ((Math.random() * (entity.getAge()[1] - entity.getAge()[0])) + entity.getAge()[0]);
        icon = entity.getIcon();
        energy = entity.getEnergy();
        stepByStep = entity.getStepByStep();
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void feed(LivingEntity food) {

    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public void live() {
        System.out.println("I'm living!");
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public LivingEntity reproduce() {
        return null;
    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public void run() {

    }
}
