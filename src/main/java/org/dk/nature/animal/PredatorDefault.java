package org.dk.nature.animal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dk.action.LivingEntity;
import org.dk.environment.Position;
import org.dk.loaders.CanEat;
import org.dk.loaders.Entity;
import org.dk.nature.Natures;

import java.util.List;


@AllArgsConstructor
@ToString(callSuper = true)
public class PredatorDefault extends Predators{
    public PredatorDefault(Entity entity) {
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
    public void feed() {
        super.live();
    }


    @Override
    public void live() {
        super.live();
    }

    @Override
    public Natures reproduce() {


        return null;
    }


}
