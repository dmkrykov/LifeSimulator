package org.dk.nature.animal;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.dk.loaders.Entity;
import org.dk.nature.Natures;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString(callSuper = true)
public class HerbivoreDefault extends Herbivore {

    public HerbivoreDefault(Entity entity) {
        name = entity.getName();
        age = (int) ((Math.random() * (entity.getAge()[1] - entity.getAge()[0])) + entity.getAge()[0]);
        maxAge = entity.getMaxAge();
        icon = entity.getIcon();
        group = entity.isGroup();
        energy = entity.getEnergy();
        stepByStep = entity.getStepByStep();
        entityType = entity.getEntityType();
        canEat = entity.getCanEat();
        maxFood = entity.getMaxFood();
        weight = entity.getWeight();
    }

    @Override
    public void live() {
        super.live();
    }

    @Override
    public void feed(Map<String, List<Natures>> entity) {
//        System.out.println("HerbivoreDefault feed " + name);
    }
}
