package org.dk.nature.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Predators extends Animals {
    private double speed;

    @Override
    public void live() {
        System.out.println("I'm Predators!");
    }

}
