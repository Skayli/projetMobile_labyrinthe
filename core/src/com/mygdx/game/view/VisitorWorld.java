package com.mygdx.game.view;

import com.mygdx.game.model.cannon.Cannon;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.Wall;

/**
 * Classe abstraite utilisé pour le design pattern Visitor afin de dessiner une bille avec la librairie graphique de son choix
 */
public abstract class VisitorWorld {

    public VisitorWorld() {}

    public abstract void draw(GameWorld game);

    public abstract void draw(Wall wall);

    public abstract void draw(Hole hole);

    public abstract void draw(Cannon cannon);

    // ------------------------------------- \\
    // --- Fin de la classe VisitorWorld --- \\
    // ------------------------------------- \\
}
