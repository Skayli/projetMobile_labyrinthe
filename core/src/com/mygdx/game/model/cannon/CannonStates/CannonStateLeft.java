package com.mygdx.game.model.cannon.CannonStates;

import com.mygdx.game.model.cannon.Cannon;

public class CannonStateLeft extends CannonState {

    public  CannonStateLeft(Cannon cannon) {
        super(cannon);
    }

    @Override
    public void update() {
        cannon.setAngle(cannon.getAngle() + 1);
        System.out.println("turning left");

        if(cannon.getAngle() > cannon.getSeuilLeft()) {
            cannon.setCurrentState(cannon.getStateTurnRight());
        }
    }


}
