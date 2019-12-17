package com.mygdx.game.model.laser.LaserStates;

import com.mygdx.game.model.laser.Laser;

public abstract class LaserState {

    Laser laser;

    public LaserState(Laser laser) {
        this.laser = laser;
    }

    public abstract void update();
}
