package org.dk.nature.plant;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.dk.action.LivingEntity;
import org.dk.loaders.Entity;
import org.dk.nature.Natures;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@ToString(callSuper = true)
public class Tree extends Plants{

    public Tree(Entity entity) {
        name = entity.getName();
        age = (int) ((Math.random() * (entity.getAge()[1] - entity.getAge()[0])) + entity.getAge()[0]);
        maxAge = entity.getMaxAge();
        icon = entity.getIcon();
        group = entity.isGroup();
        energy = entity.getEnergy();
    }

    @Override
    public void photosynthesize() {

    }

    @Override
    public void live() {

    }

    @Override
    public Natures reproduce() {
        return null;
    }

    @Override
    public void feed(Map<String, List<Natures>> entity) {
//        System.out.println("plants");
    }
}
