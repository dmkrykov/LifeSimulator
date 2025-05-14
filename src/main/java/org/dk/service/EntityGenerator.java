package org.dk.service;

import org.dk.loaders.Entity;
import org.dk.nature.Natures;
import org.dk.nature.animal.PredatorDefault;
import org.dk.nature.plant.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityGenerator {

    public EntityGenerator() {}

    public Map<String, List<Natures>> generateNatures(List<Entity> entitys) {
        Map<String, List<Natures>> map = new HashMap<>();
        for (Entity entity : entitys) {
            switch(entity.getEntityType()){
                case "predator" -> {
                    List<Natures> natures = new ArrayList<>();
                    for (int i = 0; i < entity.getCount(); i++) {
                        Natures animal = new PredatorDefault(entity);
                        natures.add(animal);
                    }
                    map.put("predator", natures);
                }
                case "herbivore" ->{

                }
                case "plant" -> {
                    List<Natures> natures = new ArrayList<>();
                    for (int i = 0; i < entity.getCount(); i++) {
                        Natures plant = new Tree(entity);
                        natures.add(plant);
                    }
                    map.put("plant", natures);
                }
            }
        }
        return map;
    }
}
