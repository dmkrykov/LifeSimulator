package org.dk.nature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dk.action.Feedable;
import org.dk.action.LivingEntity;
import org.dk.action.Reproducible;
import org.dk.environment.Position;
import org.dk.loaders.CanEat;

import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Natures implements LivingEntity, Reproducible, Feedable<Map<String, List<Natures>>> {
	protected String name;
	protected String icon;
	protected int age;
	protected Position currentPosition;
	protected Integer countInFlock;
	protected double energy;
	protected boolean group;
	protected String entityType;
	protected Integer maxAge;
	protected Boolean isDie;
	protected List<CanEat> canEat;

	@Override
	public void live() {
		if (age < maxAge){
			age++;
//			System.out.println(name+" live "+ age);
		}else{
			isDie = true;
		}
	}

//	@Override
//	public void feed(Map<String, List<Natures>> entity) {
//
//	}


	@Override
	public Natures reproduce() {
		return null;
	}
}
