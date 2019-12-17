package com.mygdx.game.model.level.levelComponent;

import com.mygdx.game.model.Hole;
import com.mygdx.game.model.MaCollision;
import com.mygdx.game.model.level.AbstractLevel;
import com.mygdx.game.model.sound.SoundManager;
import com.mygdx.game.view.VisitorWorld;

import java.util.ArrayList;

public class LevelComponentHole extends DecoratorLevelComponent {

    Hole hole;

    public LevelComponentHole(LevelComponent levelComponent, AbstractLevel level, Hole hole)
    {
        super(levelComponent, level);
        this.hole = hole;
    }

    @Override
    public void update() {
        this.levelComponentDecore.update();
        if (MaCollision.collisionHole(this.level.getGameWorld().getBall(), hole) && this.level.getGameWorld().getBall().getCurrentGameBallState() == this.level.getGameWorld().getBall().getGameBallStateAlive())
        {
//            SoundManager.getInstance().play(SoundManager.death, .5f);
//            this.level.getGameWorld().getBall().setCurrentGameBallState(this.level.getGameWorld().getBall().getGameBallStateDead());
            this.level.getGameWorld().gameOver();
        }
    }

    @Override
    public void draw(VisitorWorld visitorWorld) {
        this.levelComponentDecore.draw(visitorWorld);
        visitorWorld.draw(hole);
    }
}
