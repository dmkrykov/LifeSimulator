package org.dk.nature.animal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dk.action.Feedable;
import org.dk.action.Movable;
import org.dk.environment.Position;
import org.dk.nature.Natures;


@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class Animals extends Natures implements Feedable, Movable {
    protected Position position;

    @Override
    public void move(){

    }

    // Абстрактные методы, которые должны быть реализованы в подклассах
    public abstract void makeSound();

}
