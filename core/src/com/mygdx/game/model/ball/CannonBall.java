package com.mygdx.game.model.ball;

import com.mygdx.game.model.GameWorld;
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

    public CannonBall(GameWorld game, Vecteur position) {
        super(game, position, 100, 1, Color.RED());
    }

    public CannonBall(GameWorld game) {
        super(game, new Vecteur(0,0), 100, 1, Color.RED());
    }

    @Override
    public void update() {
        this.currentTimeLived++;
    }

    // ---------------------------------- \\
    // --- Fin de la class CannonBall --- \\
    // ---------------------------------- \\
}
