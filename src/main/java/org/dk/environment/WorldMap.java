package org.dk.environment;

import lombok.Data;
import lombok.ToString;
import org.dk.WorldConfigurator;
import org.dk.nature.Natures;
import org.dk.nature.animal.Animals;

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
    }

    /**
     * Initialize method natures on map cells
     */
    private void initialize() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Map<String, List<Natures>> natures = new HashMap<>();
                int finalI = i;
                int finalJ = j;
                worldConfigurator.getNaturesMap().forEach((k, v) -> {
                    List<Natures> temp = new ArrayList<>();
                    v.forEach(n -> {
                        if (n.getCurrentPosition().getX() == finalI && n.getCurrentPosition().getY() == finalJ) {
                            temp.add(n);
                        }
                    });
                    if (!temp.isEmpty()) {
                        natures.put(k, temp);
                    }
                });
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

    public void setMove() {
        System.out.println("Setting move");
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                cells[i][j].getNatures().forEach((k, v) -> {
                    v.forEach(n -> {
                        if (n instanceof Animals animals) {
                            Direction accessDirection = getRandomDirection(cells[finalI][finalJ].getDirections());
                            animals.move(accessDirection, worldConfigurator.getPosition());
                        }
                    });
                });
            }
        }
        movableToNewCell();
    }

    private void movableToNewCell() {
        System.out.println("movableToNewCell");
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                cells[i][j].getNatures().forEach((k, v) -> {
                    Iterator<Natures> iterator = v.iterator();
                    while (iterator.hasNext()) {
                        Natures n = iterator.next(); // Обязательно вызываем next() перед remove()
                        if (n instanceof Animals animals) {
                            Position thisPosition = new Position(finalI, finalJ);
                            if (!animals.getCurrentPosition().equals(thisPosition)) {
                                Map<String, List<Natures>> otherNatures =
                                        cells[animals.getCurrentPosition().getX()][animals.getCurrentPosition().getY()].getNatures();

                                // Создаем копию ключей для безопасной итерации
                                List<String> keys = new ArrayList<>(otherNatures.keySet());
                                boolean wasTransferred = false;

                                for (String k2 : keys) {
                                    if (k.equals(k2)) {
                                        otherNatures.get(k2).add(n);
                                        iterator.remove(); // OK: next() уже вызван
                                        wasTransferred = true;
                                        break;
                                    }
                                }

                                if (!wasTransferred) {
                                    List<Natures> newNatures = new ArrayList<>();
                                    newNatures.add(n);
                                    otherNatures.put(k, newNatures);
                                    iterator.remove(); // OK: next() уже вызван
                                }
                            }
                        }
                    }
                });
                deleteEmpty(i, j);
            }
        }
    }

    private void deleteEmpty(int x, int y) {
        List<String> forDelete = new ArrayList<>();
        cells[x][y].getNatures().forEach((k, v) -> {
            if (v.size() == 0)
                forDelete.add(k);
        });
        if (!forDelete.isEmpty()) {
            forDelete.forEach(k -> cells[x][y].getNatures().remove(k));
        }
    }

    public static Direction getRandomDirection(Set<Direction> directions) {
        if (directions == null || directions.isEmpty()) {
            throw new IllegalArgumentException("Set не может быть пустым или null");
        }

        Random random = new Random();
        int skipCount = random.nextInt(directions.size());

        Iterator<Direction> iterator = directions.iterator();
        Direction selectedDirection = null;

        // Пропускаем случайное количество элементов
        for (int i = 0; i <= skipCount; i++) {
            selectedDirection = iterator.next();
        }

        return selectedDirection;
    }
}
