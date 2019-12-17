package com.mygdx.game.model.level.levelComponent;

import com.mygdx.game.model.level.AbstractLevel;
import com.mygdx.game.view.VisitorWorld;

public abstract class DecoratorLevelComponent extends LevelComponent {

    protected LevelComponent levelComponentDecore;

    public DecoratorLevelComponent(LevelComponent levelComponentDecore, AbstractLevel level)
    {
        super(level);
        this.levelComponentDecore = levelComponentDecore;
    }

    public abstract void update();

    public abstract void draw(VisitorWorld visitorWorld);
}
