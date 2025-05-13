package org.dk.environment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Builder
@Data
public class Position {
    private int x;
    private int y;
}
