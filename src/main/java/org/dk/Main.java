package org.dk;


import org.dk.environment.WorldMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        WorldConfigurator configurator = new WorldConfigurator();
        WorldMap worldMap = new WorldMap(configurator);

        try (ExecutorService executorService = Executors.newFixedThreadPool(configurator.CPU_COUNT)) {

            //todo add thread

            executorService.shutdown();
        }

    }
}