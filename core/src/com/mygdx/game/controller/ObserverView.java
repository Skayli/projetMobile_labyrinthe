package com.mygdx.game.controller;

import com.mygdx.game.model.GameWorld;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe observant la vue
 */
public class ObserverView implements Observer {

    Controller controller;

    public ObserverView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void update(Observable observable, Object o) {
        GameWorld game = (GameWorld) o;
        controller.updateModel(game);
    }

    // ------------------------------------- \\
    // --- Fin de la classe ObserverView --- \\
    // ------------------------------------- \\
}
