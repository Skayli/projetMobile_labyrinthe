package com.mygdx.game.view;

import com.mygdx.game.model.GameWorld;

/**
 * Classe abstraite utilisé pour le design pattern Visitor afin de dessiner une bille avec la librairie graphique de son choix
 */
public abstract class VisitorWorld {

    public VisitorWorld() {}

    public abstract void draw(GameWorld game);

    // ------------------------------------- \\
    // --- Fin de la classe VisitorWorld --- \\
    // ------------------------------------- \\
}
