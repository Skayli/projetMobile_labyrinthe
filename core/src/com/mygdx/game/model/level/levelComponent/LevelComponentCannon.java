package com.mygdx.game.model.level.levelComponent;

import com.mygdx.game.model.cannon.Cannon;
import com.mygdx.game.model.level.AbstractLevel;
import com.mygdx.game.view.VisitorWorld;

public class LevelComponentCannon extends DecoratorLevelComponent {

    Cannon cannon;

    public LevelComponentCannon(LevelComponent levelComponentDecore, AbstractLevel level, Cannon cannon)
    {
        super(levelComponentDecore, level);
        this.cannon = cannon;
    }

    @Override
    public void update() {
        this.levelComponentDecore.update();
        cannon.update();
    }

    @Override
    public void draw(VisitorWorld visitorWorld) {
        this.levelComponentDecore.draw(visitorWorld);
        visitorWorld.draw(this.cannon);
    }
}
