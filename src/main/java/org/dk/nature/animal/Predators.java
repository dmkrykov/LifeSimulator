package org.dk.nature.animal;

import lombok.*;
import org.dk.nature.Natures;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@ToString(callSuper = true)
public abstract class Predators extends Animals {

    @Override
    public Natures reproduce() {
        return null;
    }
}
