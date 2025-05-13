package org.dk.nature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.dk.action.LivingEntity;
import org.dk.action.Reproducible;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Natures implements LivingEntity, Reproducible {
    protected String name;
    protected String icon;
    protected int age;
}
