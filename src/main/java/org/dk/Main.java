package org.dk;


import org.dk.action.View;
import org.dk.environment.WorldMap;
import org.dk.service.ViewConsole;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WorldConfigurator configurator = new WorldConfigurator();
        WorldMap worldMap = new WorldMap(configurator);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(configurator.CPU_COUNT);


        executor.scheduleAtFixedRate(() -> {
             // Затем выводим
            worldMap.setMove();  // Сначала обновляем карту
            View view = new ViewConsole(worldMap);
            System.out.println(view.getView());
        }, 0, 1, TimeUnit.SECONDS);

        // Останавливаем через 5 секунд
//        executor.schedule(() -> {
//            executor.shutdown();
//            try {
//                if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
//                    executor.shutdownNow();
//                }
//            } catch (InterruptedException e) {
//                executor.shutdownNow();
//            }
//        }, 15, TimeUnit.SECONDS);

    }
}