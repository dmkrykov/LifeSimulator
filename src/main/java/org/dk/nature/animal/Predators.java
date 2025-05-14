package org.dk.nature.animal;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class Predators extends Animals {
    private double speed;

    @Override
    public void live() {
        System.out.println("I'm Predators!");
    }

}
