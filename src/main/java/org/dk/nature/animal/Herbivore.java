package org.dk.nature.animal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dk.action.LivingEntity;
import org.dk.environment.Position;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@ToString(callSuper = true)
public abstract class Herbivore extends Animals{
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
