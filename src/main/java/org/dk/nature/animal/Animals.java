package org.dk.nature.animal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dk.action.Feedable;
import org.dk.action.LivingEntity;
import org.dk.action.Movable;
import org.dk.environment.Direction;
import org.dk.environment.Position;
import org.dk.nature.Natures;

import java.util.Random;


@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class Animals extends Natures implements Feedable, Movable {
    protected Position position;
    protected int stepByStep;
    protected float maxFood;
    protected float weight;


    @Override
    public Position move(Direction direction, Position mapSize){
        Random random = new Random();
        int step = random.nextInt(stepByStep) + 1;

        // Вычисляем новую позицию
        int newX = currentPosition.getX();
        int newY = currentPosition.getY();

        switch (direction) {
            case RIGHT:
                newX = Math.min(newX + step, mapSize.getX() - 1);
                break;
            case LEFT:
                newX = Math.max(newX - step, 0);
                break;
            case UP:
                newY = Math.min(newY + step, mapSize.getY() - 1);
                break;
            case DOWN:
                newY = Math.max(newY - step, 0);
                break;
        }

        // Обновляем текущую позицию и возвращаем её
        currentPosition = new Position(newX, newY);
        return currentPosition;
    }
}
