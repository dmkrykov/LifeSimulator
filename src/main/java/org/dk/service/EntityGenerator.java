package org.dk.service;

import org.dk.environment.Position;
import org.dk.loaders.Entity;
import org.dk.loaders.WorldLoader;
import org.dk.nature.Natures;
import org.dk.nature.animal.HerbivoreDefault;
import org.dk.nature.animal.PredatorDefault;
import org.dk.nature.plant.Tree;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntityGenerator {
    private final WorldLoader worldLoader;

    public EntityGenerator(WorldLoader worldLoader) {
        this.worldLoader = worldLoader;
    }

    public Map<String, List<Natures>> generateNatures(List<Entity> entitys) {
        Map<String, List<Natures>> map = new HashMap<>();

        for (Entity entity : entitys) {
            switch (entity.getEntityType()) {
                case "predator" -> entityConfigurator("predator", entity, map, () -> new PredatorDefault(entity));
                case "herbivore" -> entityConfigurator("herbivore", entity, map, () -> new HerbivoreDefault(entity));
                case "plant" -> entityConfigurator("plant", entity, map, () -> new Tree(entity));
                default -> throw new IllegalStateException("Unexpected value: " + entity.getEntityType());
            }
        }
        return map;
    }

    private void entityConfigurator(String entityType, Entity entity, Map<String, List<Natures>> map, Supplier<? extends Natures> natureSupplier) {
        Map<String, Integer> distributed = distributeUniformly(worldLoader.getSizeX(), worldLoader.getSizeY(), entity.getCount());
        int count = distributed.size();
        //todo сделать генерацию когда группа false
        List<Natures> natures = IntStream
                .range(0, count)
                .mapToObj(i -> {
                    Natures nature = natureSupplier.get();
                    if(!distributed.isEmpty()){
                        String randomKey = distributed.keySet().iterator().next();
                        String[] stPosition = randomKey.split(",");

                        nature.setCurrentPosition(new Position(Integer.parseInt(stPosition[0]),Integer.parseInt(stPosition[1])));
                        if(nature.isGroup()) {
                            Integer value = distributed.get(randomKey);
                            nature.setCountInFlock(value);
                        }else{
                            nature.setCountInFlock(0);
                        }
                        distributed.remove(randomKey);
                    }
                    return nature;
                })
                .collect(Collectors.toList());

        if (map.containsKey(entityType)) {
            map.get(entityType).addAll(natures);
        } else {
            map.put(entityType, natures);
        }
    }

    /**
     * Calculates the normal distribution
     *
     * @param mapWidth  equal x
     * @param mapHeight equal y
     * @param totalCount The maximum amount of the species
     */
    private Map<String, Integer> distributeUniformly(int mapWidth, int mapHeight, int totalCount) {
        int cells = mapWidth * mapHeight;
        int basePerCell = totalCount / cells; // Basic amount per cell
        int remainder = totalCount % cells;   // Residue for random distribution

        Map<String, Integer> distribution = new HashMap<>();

        Random random = new Random();

        // Uniform filling
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                String key = x + "," + y;
                distribution.put(key, basePerCell);
            }
        }

        // We distribute the rest by chance
        for (int i = 0; i < remainder; i++) {
            int x = random.nextInt(mapWidth);
            int y = random.nextInt(mapHeight);
            String key = x + "," + y;
            distribution.put(key, distribution.get(key) + 1);
        }

        distribution.entrySet().removeIf(e -> e.getValue() == 0);

        return distribution;
    }
}
