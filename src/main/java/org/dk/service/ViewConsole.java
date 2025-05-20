package org.dk.service;

import lombok.Data;
import org.dk.action.View;
import org.dk.environment.Cell;
import org.dk.environment.WorldMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
public class ViewConsole implements View<String> {
    private Map<String, Integer> countNatures;
    private StringBuilder sbRows;
    private final WorldMap worldMap;

    public ViewConsole(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.countNatures = new HashMap<>();
        this.sbRows = new StringBuilder();
    }

    private void calculateStatistic(Cell[][] cells) {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                synchronized (cell) {
                    cell.getNatures().forEach((map) -> {
                        map.forEach((k, v) -> {
                            v.forEach(n -> {
                                if (countNatures.containsKey(n.getIcon())) {
                                    Integer current = countNatures.get(n.getIcon());
                                    current++;
                                    current+=n.getCountInFlock();
                                    countNatures.put(n.getIcon(), current);
                                } else {
                                    countNatures.put(n.getIcon(), 1);
                                }
                            });
                        });

                    });
                }
            }
        }
    }

    private String drawCell(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if(cells[i][j].getNatures().isEmpty()){
                    sbRows.append("*").append("|");
                }
                cells[i][j].getNatures().forEach((map) -> {
                    worldMap.getWorldConfigurator().getNaturesMap().forEach((k, v) -> {
                        if(map.containsKey(k)){
                            sbRows.append(k.substring(0,1).toUpperCase());
                            sbRows.append(k.substring(1,2).toLowerCase());
                        }
                    });
                });
                sbRows.append("|");
            }
            sbRows.append("\n");
        }

        return "";
    }


    @Override
    public String getView() {
        calculateStatistic(worldMap.getCells());
        drawCell(worldMap.getCells());
        StringBuilder sb = new StringBuilder();
        sb
                .append("Current statistics: ")
                .append(worldMap.getWorldConfigurator().getName())
                .append("\n")
                .append(countNatures.toString())
                .append("\n")
                .append(sbRows.toString());

        return sb.toString();
    }
}
