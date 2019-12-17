package com.mygdx.game.model.cannon.CannonStates;

import com.mygdx.game.model.cannon.Cannon;

public class CannonStateRight extends CannonState {

    public CannonStateRight(Cannon cannon) {
        super(cannon);
    }

    @Override
    public void update() {
        cannon.setAngle(cannon.getAngle() - cannon.getTurningSpeed());

        if(cannon.getAngle() < cannon.getSeuilRight()) {
            cannon.setCurrentState(cannon.getStateTurnLeft());
        }
    }

}
