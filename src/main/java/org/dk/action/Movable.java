package org.dk.action;

import org.dk.environment.Direction;
import org.dk.environment.Position;

// Интерфейс для подвижных сущностей
@FunctionalInterface
public interface Movable {
    // получаем направление от ячейки и возвращаем новое направление, внутри записать в currentPosition
    Position move(Direction direction, Position mapSize);

}
