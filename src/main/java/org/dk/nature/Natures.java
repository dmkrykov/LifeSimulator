package org.dk.nature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dk.action.LivingEntity;
import org.dk.action.Reproducible;
import org.dk.environment.Position;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Natures implements LivingEntity, Reproducible, Runnable {
    protected String name;
    protected String icon;
    protected int age;
    protected Position currentPosition;
    protected Integer countInFlock;
    protected double energy;
    protected int stepByStep;
    protected boolean group;
}
