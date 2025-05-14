package org.dk.loaders;

import lombok.Data;

@Data
public class Entity {
	private String name;
	private String entityType;
	private int maxCountInMap;
	private int[] age;
	private int speed;
	private int count;
	private String icon;
	private float weight;
	private int maxTypeCell;
	private int stepByStep;
	private float maxFood;
	private String[] canEat;
}
