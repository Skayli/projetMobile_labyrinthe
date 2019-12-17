package com.mygdx.game.model.level.levelComponent;

import com.mygdx.game.model.Hole;
import com.mygdx.game.model.MaCollision;
import com.mygdx.game.model.level.AbstractLevel;
import com.mygdx.game.model.sound.SoundManager;
import com.mygdx.game.view.VisitorWorld;

import java.util.ArrayList;

public class LevelComponentHole extends DecoratorLevelComponent {

    ArrayList<Hole> holes;

    public LevelComponentHole(LevelComponent levelComponent, AbstractLevel level, ArrayList<Hole> holes)
    {
        super(levelComponent, level);
        this.holes = holes;
    }

    @Override
    public void update() {
        this.levelComponentDecore.update();
        for(Hole hole: this.holes)
        {
            if (MaCollision.collisionHole(this.level.getGameWorld().getBall(), hole))
            {
                SoundManager.getInstance().play(SoundManager.death, .5f);
                this.level.getGameWorld().getBall().setCurrentGameBallState(this.level.getGameWorld().getBall().getGameBallStateDead());
            }
        }
    }

    @Override
    public void draw(VisitorWorld visitorWorld) {
        this.levelComponentDecore.draw(visitorWorld);
        for(Hole hole : this.holes)
        {
            visitorWorld.draw(hole);
        }
    }
}
