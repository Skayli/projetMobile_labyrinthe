package com.mygdx.game.model.cannon.CannonStates;

import com.mygdx.game.model.cannon.Cannon;

public abstract class CannonState {

    Cannon cannon;

    public CannonState(Cannon cannon) {
        this.cannon = cannon;
    }

    public abstract void update();
}
