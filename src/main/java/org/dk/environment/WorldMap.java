package org.dk.environment;

import lombok.Data;
import lombok.ToString;
import org.dk.WorldConfigurator;
import org.dk.nature.Natures;

import java.util.*;


@Data
@ToString
public class WorldMap {
    private final WorldConfigurator worldConfigurator;

    private Cell[][] cells;

    public WorldMap(WorldConfigurator worldConfigurator) {
        this.worldConfigurator = worldConfigurator;
        cells = new Cell[worldConfigurator.getPosition().getX()][worldConfigurator.getPosition().getY()];
        initialize();

        System.out.println(Arrays.deepToString(cells));
    }

    private void initialize() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Set<Map<String, List<Natures>>> natures = new HashSet<>();
                natures.add(worldConfigurator.getNaturesMap());
                cells[i][j] = new Cell(getAvailableTerrain(), getAvailableDirections(i, j), natures);
            }
        }
    }

    private Set<Direction> getAvailableDirections(int x, int y) {
        Set<Direction> directions = new HashSet<>();

        if (x < worldConfigurator.getPosition().getX() - 1) {  // Можно идти вправо, если не на правой границе
            directions.add(Direction.RIGHT);
        }
        if (x > 0) {  // Можно идти влево, если не на левой границе
            directions.add(Direction.LEFT);
        }
        if (y > 0) {  // Можно идти вверх, если не на верхней границе
            directions.add(Direction.UP);
        }
        if (y < worldConfigurator.getPosition().getY() - 1) {  // Можно идти вниз, если не на нижней границе
            directions.add(Direction.DOWN);
        }

        return directions;
    }

    private Terrain getAvailableTerrain() {
        // Добавляем элементы с разной частотой (например, GROUND встречается чаще)
        List<Terrain> terrains = new java.util.ArrayList<>();
        terrains.addAll(Collections.nCopies(5, Terrain.GROUND));   // 50% шанс
        terrains.addAll(Collections.nCopies(2, Terrain.WATER));    // 20% шанс
        terrains.addAll(Arrays.asList(
                Terrain.MOUNTAIN,
                Terrain.ROCK,
                Terrain.LAVA
        )); // По 10% шанс
        List<Terrain> weightedTerrains = Collections.unmodifiableList(terrains);

        Random rand = new Random();
        return weightedTerrains.get(rand.nextInt(weightedTerrains.size()));
    }
}
