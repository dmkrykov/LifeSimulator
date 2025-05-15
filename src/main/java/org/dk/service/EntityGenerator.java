package org.dk.service;

import org.dk.loaders.Entity;
import org.dk.nature.Natures;
import org.dk.nature.animal.HerbivoreDefault;
import org.dk.nature.animal.PredatorDefault;
import org.dk.nature.plant.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntityGenerator {

    public EntityGenerator() {}

    public Map<String, List<Natures>> generateNatures(List<Entity> entitys) {
        Map<String, List<Natures>> map = new HashMap<>();
        for (Entity entity : entitys) {
            switch(entity.getEntityType()){
                case "predator" -> {
                    List<Natures> natures = IntStream
                            .range(0, entity.getCount())
                            .mapToObj(i -> new PredatorDefault(entity))
                            .collect(Collectors.toList());
                    map.put("predator", natures);
                }
                case "herbivore" ->{
                    List<Natures> natures = IntStream
                            .range(0, entity.getCount())
                            .mapToObj(i -> new HerbivoreDefault(entity))
                            .collect(Collectors.toList());
                    map.put("herbivore", natures);
                }
                case "plant" -> {
                    List<Natures> natures = IntStream
                            .range(0, entity.getCount())
                            .mapToObj(i -> new Tree(entity))
                            .collect(Collectors.toList());
                    map.put("plant", natures);
                }
            }
        }
        return map;
    }
}
