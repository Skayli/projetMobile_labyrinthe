package com.mygdx.game.model;

import com.mygdx.game.model.ball.CannonBall;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant le canon du level 3 des petites billes sur la bille contrôlée par le joueur
 */
public class Cannon {

    private Vecteur position;
    private CannonBall cannonBall; // bille tirée par le canon

    /**
     * !!! ATTENTION !!! => a voir : gestion de la bille de canon (1 seule bille, tableau de bille, etc ...)
     */

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    public Cannon(Vecteur position) {
        this.position = position;
    }

    public Cannon() {
        this.position = new Vecteur(0,0);
    }

    // ----------------- \\
    // --- Fonctions --- \\
    // ----------------- \\

    public void update() {
        //Gestion des billes tirées par le canon (et rotation pour se placer sur le prochain tir ?)
    }

    // ------------------------- \\
    // --- Getters & setters --- \\
    // ------------------------- \\

    public Vecteur getPosition() {
        return position;
    }

    public void setPosition(Vecteur position) {
        this.position = position;
    }

    // ------------------------------ \\
    // --- Fin de la class Cannon --- \\
    // ------------------------------ \\
}
