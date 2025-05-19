package org.dk.nature.animal;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@ToString(callSuper = true)
public abstract class Predators extends Animals {

    @Override
    public void live() {
        System.out.println("I'm Predators!");
    }

}
