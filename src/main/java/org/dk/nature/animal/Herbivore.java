package org.dk.nature.animal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.dk.loaders.CanEat;
import org.dk.nature.Natures;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@ToString(callSuper = true)
public abstract class Herbivore extends Animals{

    @Override
    public double getEnergy() {
        return energy;
    }


    @Override
    public void feed() {

    }

    @Override
    public Natures reproduce() {
        return null;
    }

}
