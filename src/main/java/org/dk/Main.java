package org.dk;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        Order order = mapper.readValue(new File("src/main/resources/worldConf.yml"), Order.class);
        System.out.println(order);
    }

    @Data
    static class Order {
        private String worldName;
        private LocalDate date;
        private int sizeX;
        private int sizeY;
        private List<WorldEntity> worldEntity;

        // Constructors, Getters, Setters and toString
    }

    @Data
    static class WorldEntity {
        private String configFile;
        private String entityType;
    }
}