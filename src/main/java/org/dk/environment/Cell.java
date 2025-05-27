package org.dk.environment;

import lombok.Data;
import org.dk.action.Feedable;
import org.dk.action.LivingEntity;
import org.dk.nature.Natures;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class Cell implements Feedable, LivingEntity {
	private Terrain terrain;
	private Set<Direction> directions;
	private Map<String, List<Natures>> natures;

	public Cell(Terrain terrain, Set<Direction> directions, Map<String, List<Natures>> natures) {
		this.terrain = terrain;
		this.directions = directions;
		this.natures = natures;
	}

	@Override
	public void feed() {
		natures.forEach((k, v) -> {
			v.forEach(Natures::feed);
		});
	}

	@Override
	public void live() {
		natures.forEach((k, v) -> {
			v.forEach(Natures::live);
		});
	}
}
