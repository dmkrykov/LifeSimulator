package org.dk;


import org.dk.action.View;
import org.dk.environment.WorldMap;
import org.dk.service.ViewConsole;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        WorldConfigurator configurator = new WorldConfigurator();
        WorldMap worldMap = new WorldMap(configurator);
        View view = new ViewConsole(worldMap);


        try (ExecutorService executorService = Executors.newFixedThreadPool(configurator.CPU_COUNT)) {

            System.out.println(view.getView());
            //todo add thread

            executorService.shutdown();
        }

    }
}