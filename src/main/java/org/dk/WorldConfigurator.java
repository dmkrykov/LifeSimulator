package org.dk;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import org.dk.action.WorldSim;
import org.dk.exception.LoadResource;
import org.dk.loaders.Entity;
import org.dk.loaders.Predator;
import org.dk.loaders.WorldLoader;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

@Getter
public class WorldConfigurator implements WorldSim {
	private final String CONFIG_FILE = "worldConf.yml";
	private final int sizeX;
	private final int sizeY;
	private final String name;
	private final WorldLoader worldLoader;

	public WorldConfigurator() {
		try {
			Optional<URL> url= Optional.ofNullable(WorldConfigurator.class.getClassLoader().getResource(CONFIG_FILE));
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapper.findAndRegisterModules();

			File file = new File(url.get().getFile());
			if (!file.exists()) {
				throw new LoadResource("Configuration file " + CONFIG_FILE + " does not exist");
			}
			worldLoader = mapper.readValue(file, WorldLoader.class);
			name = worldLoader.getWorldName();
			sizeX = worldLoader.getSizeX();
			sizeY = worldLoader.getSizeY();

			worldLoader.getWorldEntity().forEach(e ->{
				Optional<URL> entityConfUrl = Optional.ofNullable(WorldConfigurator.class.getClassLoader().getResource(e.getConfigFile()));
				File fileIn = new File(entityConfUrl.get().getFile());
				try {
					Predator entity = mapper.readValue(fileIn, Predator.class);
					System.out.println(entity);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			});

			System.out.println(worldLoader);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
