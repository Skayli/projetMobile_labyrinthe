package com.mygdx.game.model.ball;

import com.mygdx.game.model.color.Color;
import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant une bille de jeu (celle contrôlée par le joueur)
 */
public class GameBall extends AbstractBall {

    //Données relatives aux GameBall
    private static final int gameBallDiameter = 250;
    private static final double gameBallWeight = 5;
    private static final Color gameBallColor = Color.BLUE();

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\
    public GameBall() {
        super(new Vecteur(0,0), gameBallDiameter, gameBallWeight, gameBallColor);
    }

    public GameBall(Vecteur position) {
        super(position, gameBallDiameter, gameBallWeight, gameBallColor);
    }

    // Gestion du déplacement d'une GameBall
    @Override
    public void update() {

    }

    // -------------------------------- \\
    // --- Fin de la class GameBall --- \\
    // -------------------------------- \\
}
