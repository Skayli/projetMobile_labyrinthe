package com.mygdx.game.model.laser.LaserStates;

import com.mygdx.game.model.laser.Laser;

public class LaserStateDead extends LaserState {

    public LaserStateDead(Laser laser) {
        super(laser);
    }

    @Override
    public void update() {
        if(laser.getSeuil() > laser.getTimeDead()) {
            laser.setSeuil(0);
            laser.setCurrentState(laser.getStateAlive());
        }
    }
}
