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

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(configurator.CPU_COUNT);

        // Запускаем вывод каждую секунду
        executorService.scheduleAtFixedRate(
                () -> {
                    CompletableFuture.runAsync(worldMap::setMove, executorService);

                    CompletableFuture.runAsync(() -> {
                        View view = new ViewConsole(worldMap);
                        System.out.println(view.getView());
                    }, executorService);
                },
                0, 1, TimeUnit.SECONDS
        );

        // Останавливаем через 5 секунд
        executorService.schedule(() -> {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        }, 5, TimeUnit.SECONDS);

    }
}