package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Wall;

public class Level4 extends AbstractLevel {

    public Level4(GameWorld world) {
        super(world);

        world.getBall().setPosition(7000,5000);

        this.walls.add(Wall.createWall(500,500,11500,500));
        this.walls.add(Wall.createWall(500,7000,500,500));
        this.walls.add(Wall.createWall(11500,500,11500,7000));
    }


    @Override
    public AbstractLevel getNextLevel() {
        return null;
    }
}
