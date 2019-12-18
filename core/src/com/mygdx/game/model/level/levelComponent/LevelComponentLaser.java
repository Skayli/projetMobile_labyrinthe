package com.mygdx.game.model.level.levelComponent;

import com.mygdx.game.model.laser.Laser;
import com.mygdx.game.model.level.AbstractLevel;
import com.mygdx.game.view.VisitorWorld;

public class LevelComponentLaser extends DecoratorLevelComponent {

    Laser laser;

    public LevelComponentLaser(LevelComponent levelComponent, AbstractLevel level, Laser laser) {
        super(levelComponent, level);
        this.laser = laser;
    }


    @Override
    public void update() {
        this.levelComponentDecore.update();
        laser.update();
    }

    @Override
    public void draw(VisitorWorld visitorWorld) {
        this.levelComponentDecore.draw(visitorWorld);
        visitorWorld.draw(laser);
    }
}
