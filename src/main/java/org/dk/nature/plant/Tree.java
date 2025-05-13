package org.dk.nature.plant;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dk.action.LivingEntity;


@AllArgsConstructor
@SuperBuilder
public class Tree extends Plants{

    @Override
    public void photosynthesize() {

    }

    @Override
    public void live() {

    }

    @Override
    public LivingEntity reproduce() {
        return null;
    }
}
