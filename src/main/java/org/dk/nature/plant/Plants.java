package org.dk.nature.plant;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dk.environment.Position;
import org.dk.nature.Natures;


@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class Plants extends Natures {
    protected Position position;
    protected double size;
    protected boolean group;


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
