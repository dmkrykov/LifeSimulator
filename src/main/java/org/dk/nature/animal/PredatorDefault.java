package org.dk.nature.animal;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.dk.loaders.Entity;
import org.dk.nature.Natures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;


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
    public void feed(Map<String, List<Natures>> natures) {
        // получаем список кого есть в ячейки из тех кого можем есть
        List<String> victim = getVictim(natures);
        //todo дописать


    }

    private List<String> getVictim(Map<String, List<Natures>> natures){
        List<String> toEat = new ArrayList<>();
        natures.forEach((k, v) -> {
            v.forEach(n ->{
                String nameAnimal = n.getName();
                canEat.forEach(animal->{
                    if (animal.getAnimal().equalsIgnoreCase(nameAnimal)) {
                        toEat.add(nameAnimal);
                        System.out.println(toEat);
                    }
                });
            });
        });
        return toEat;
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
