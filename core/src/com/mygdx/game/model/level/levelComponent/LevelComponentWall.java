package com.mygdx.game.model.level.levelComponent;

import com.mygdx.game.model.MaCollision;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.level.AbstractLevel;
import com.mygdx.game.view.VisitorWorld;

import java.util.ArrayList;

public class LevelComponentWall extends LevelComponent {

    ArrayList<Wall> walls;

    public LevelComponentWall(AbstractLevel level, ArrayList<Wall> walls)
    {
        super(level);
        this.walls = walls;
    }

    @Override
    public void update() {

        for(Wall wall : this.walls) {
            MaCollision.collisionBilleSegment(this.level.getGameWorld().getBall(), wall);
        }
    }

    @Override
    public void draw(VisitorWorld visitorWorld) {
        visitorWorld.draw(walls);
    }
}
