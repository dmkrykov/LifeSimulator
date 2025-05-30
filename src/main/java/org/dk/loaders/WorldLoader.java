package org.dk.loaders;

import lombok.Data;

import java.util.List;

@Data
public class WorldLoader {
	private String worldName;
	private int sizeX;
	private int sizeY;
	private List<String> entityTypes;
	private List<Entity> entity;

}
