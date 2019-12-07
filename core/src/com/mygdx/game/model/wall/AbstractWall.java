package com.mygdx.game.model.wall;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant les murs d'un level
 */
public abstract class AbstractWall {

    protected Vecteur beginning;
    protected Vecteur ending;

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    public AbstractWall(double beginningX, double beginningY, double endingX, double endingY) {
        this.beginning = new Vecteur(beginningX, beginningY);
        this.ending = new Vecteur(endingX, endingY);
    }

    public AbstractWall(Vecteur beginning, Vecteur ending) {
        this.beginning = beginning;
        this.ending = ending;
    }

    // ------------------------------------- \\
    // --- Fin de la classe AbstractWall --- \\
    // ------------------------------------- \\
}
