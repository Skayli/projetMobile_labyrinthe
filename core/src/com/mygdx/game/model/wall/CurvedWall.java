package com.mygdx.game.model.wall;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant un mur courbé
 */
public class CurvedWall extends AbstractWall {

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    public CurvedWall(double beginningX, double beginningY, double endingX, double endingY) {
        super(beginningX, beginningY, endingX, endingY);
    }

    public CurvedWall(Vecteur beginning, Vecteur ending) {
        super(beginning, ending);
    }

    // ----------------------------------- \\
    // --- Fin de la classe CurvedWall --- \\
    // ----------------------------------- \\

}
