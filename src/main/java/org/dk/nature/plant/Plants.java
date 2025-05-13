package org.dk.nature.plant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dk.environment.Position;
import org.dk.nature.Natures;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Plants extends Natures {
    protected String name;
    protected int age;
    protected Position position;
    protected double size;


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
