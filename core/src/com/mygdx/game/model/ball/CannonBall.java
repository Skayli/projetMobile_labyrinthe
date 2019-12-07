package com.mygdx.game.model.ball;

import com.mygdx.game.model.color.Color;
import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant les billes tirées par le canon
 */
public class CannonBall extends AbstractBall {

    private final int LIFE_TIME = 180; // Temps de vie d'une bille de canon avant le despawn;

    private int currentTimeLived = 0; // Temps vécu total


    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    public CannonBall(Vecteur position) {
        super(position, 100, 1, Color.RED());
    }

    public CannonBall() {
        super(new Vecteur(0,0), 100, 1, Color.RED());
    }

    @Override
    public void update() {
        this.currentTimeLived++;
    }

    // ---------------------------------- \\
    // --- Fin de la class CannonBall --- \\
    // ---------------------------------- \\
}
