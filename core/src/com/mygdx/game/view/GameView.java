package com.mygdx.game.view;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.view.visitor.DrawerGDX;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe représentant la vue dans le pattern MVC
 */
public class GameView implements Observer {

    VisitorWorld visitorWorld;

    public GameView(VisitorWorld drawer) {
        this.visitorWorld = drawer;
    }

    @Override
    public void update(Observable observable, Object o) {
        GameWorld game = (GameWorld) o;
        this.visitorWorld.draw(game);
    }

    // --------------------------------- \\
    // --- Fin de la classe GameView --- \\
    // --------------------------------- \\
}
