package org.dk;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import org.dk.action.WorldSim;
import org.dk.environment.Position;
import org.dk.exception.LoadResource;
import org.dk.loaders.Predator;
import org.dk.loaders.WorldLoader;
import org.dk.nature.Natures;
import org.dk.nature.animal.PredatorDefault;
import org.dk.nature.plant.Tree;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Optional;

@Getter
public class WorldConfigurator implements WorldSim {
    private final String CONFIG_FILE = "worldConf.yml";

    private final String name;
    private final WorldLoader worldLoader;
    private final Position position = new Position(0, 0);

    public WorldConfigurator() {

        Optional<URL> url = Optional.ofNullable(WorldConfigurator.class.getClassLoader().getResource(CONFIG_FILE));
        if (url.isEmpty()) {
            throw new LoadResource("Configuration file " + CONFIG_FILE + " does not exist");
        }
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.findAndRegisterModules();

        try (InputStream in = url.get().openStream()) {
            worldLoader = mapper.readValue(in, WorldLoader.class);
        } catch (IOException e) {
            throw new LoadResource("Error loading configuration file " + CONFIG_FILE, e);
        }

        name = worldLoader.getWorldName();
        position.setX(worldLoader.getSizeX());
        position.setY(worldLoader.getSizeY());

        worldLoader.getWorldEntity().forEach(e -> {
            Optional<URL> entityConfUrl = Optional.ofNullable(WorldConfigurator.class.getClassLoader().getResource(e.getConfigFile()));
            if (entityConfUrl.isEmpty()) {
                throw new LoadResource("Configuration file " + e.getConfigFile() + " does not exist");
            }

            try (InputStream in = entityConfUrl.get().openStream()) {
                Predator entity = mapper.readValue(in, Predator.class);
                switch (e.getEntityType()) {
                    case "predator" -> {
                        Natures animal = PredatorDefault
                                .builder()
                                .speed(10)
                                .age(entity.getAge())
                                .name(entity.getName())
                                .icon(entity.getIcon())
                                .build();

                        System.out.println(animal.getIcon() + animal.getName());
                    }
                    case "plant" -> {
                        Natures animal = Tree
                                .builder()
                                .age(entity.getAge())
                                .name(entity.getName())
                                .icon(entity.getIcon())
                                .build();
                        System.out.println(animal.getIcon() + animal.getName());
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        System.out.println(worldLoader);

    }
}
