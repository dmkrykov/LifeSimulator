package org.dk.nature.plant;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.dk.action.LivingEntity;
import org.dk.loaders.Entity;


@AllArgsConstructor
@ToString(callSuper = true)
public class Tree extends Plants{

    public Tree(Entity entity) {
        name = entity.getName();
        age = (int) ((Math.random() * (entity.getAge()[1] - entity.getAge()[0])) + entity.getAge()[0]);
        icon = entity.getIcon();
        group = entity.isGroup();
        System.out.println(this);
    }

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

    @Override
    public void run() {

    }
}
