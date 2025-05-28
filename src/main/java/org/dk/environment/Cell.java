package org.dk.environment;

import lombok.Data;
import org.dk.action.Feedable;
import org.dk.action.LivingEntity;
import org.dk.nature.Natures;
import org.dk.nature.animal.Animals;
import org.dk.nature.animal.Predators;

import java.util.*;

@Data
public class Cell implements LivingEntity {
	private Terrain terrain;
	private Set<Direction> directions;
	private Map<String, List<Natures>> natures;

	public Cell(Terrain terrain, Set<Direction> directions, Map<String, List<Natures>> natures) {
		this.terrain = terrain;
		this.directions = directions;
		this.natures = natures;
	}

	public void feed() {
		natures.forEach((k, v) -> {
			for (Natures n : v) {
				n.feed(natures);
			}
		});
	}

	@Override
	public void live() {
		natures.forEach((k, v) -> {
			v.forEach(Natures::live);
		});
	}
}
