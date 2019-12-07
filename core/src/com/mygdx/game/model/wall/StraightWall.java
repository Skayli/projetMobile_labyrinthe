package com.mygdx.game.model.wall;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant un mur droit
 */
public class StraightWall extends AbstractWall {

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    public StraightWall(double beginningX, double beginningY, double endingX, double endingY) {
        super(beginningX, beginningY, endingX, endingY);
    }

    public StraightWall(Vecteur beginning, Vecteur ending) {
        super(beginning, ending);
    }

    // ------------------------------------- \\
    // --- Fin de la classe StraightWall --- \\
    // ------------------------------------- \\
}
