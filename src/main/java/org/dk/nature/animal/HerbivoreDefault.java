package org.dk.nature.animal;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.dk.loaders.Entity;

@AllArgsConstructor
@ToString(callSuper = true)
public class HerbivoreDefault extends Herbivore {

    public HerbivoreDefault(Entity entity) {
        name = entity.getName();
        age = (int) ((Math.random() * (entity.getAge()[1] - entity.getAge()[0])) + entity.getAge()[0]);
        icon = entity.getIcon();
        group = entity.isGroup();
        energy = entity.getEnergy();
        stepByStep = entity.getStepByStep();
    }

    @Override
    public void run() {

    }
}
