package com.mygdx.game.model.level.levelComponent;

import com.mygdx.game.model.level.AbstractLevel;
import com.mygdx.game.view.VisitorWorld;

public abstract class LevelComponent {

    AbstractLevel level;

    public LevelComponent(AbstractLevel level)
    {
        this.level = level;
    }

    public abstract void update();

    public abstract void draw(VisitorWorld visitorWorld);
}
