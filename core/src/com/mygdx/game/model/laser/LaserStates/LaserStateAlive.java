package com.mygdx.game.model.laser.LaserStates;

import com.mygdx.game.model.MaCollision;
import com.mygdx.game.model.laser.Laser;

public class LaserStateAlive extends LaserState {

    public LaserStateAlive(Laser laser) {
        super(laser);
    }

    @Override
    public void update() {
        if(MaCollision.collisionSegment(laser.getGame().getBall().getPosition(), laser.getGame().getBall().getRadius(), laser.getBeginning(), laser.getEnding()) && laser.getGame().getBall().isAlive()) {
            laser.getGame().gameOver();
        }

        if(laser.getSeuil() > laser.getTimeAlive()) {
            laser.setSeuil(0);
            laser.setCurrentState(laser.getStateDead());
        }
    }
}
