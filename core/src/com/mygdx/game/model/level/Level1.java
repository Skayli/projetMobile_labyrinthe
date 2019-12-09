package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Wall;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant le level 1
 */
public class Level1 extends AbstractLevel{

    public Level1(GameWorld gameWorld) {
        super(gameWorld);

        //Positionnement de la bille
        gameWorld.getBall().setPosition(4500,3250);

        //Création des murs du level 1
        Vecteur curveBeginning = new Vecteur(3000,3250);
        Vecteur curveEnding = new Vecteur(9000, 3250);
        Vecteur curveControlPoint = new Vecteur(6000, 0);
        this.walls.addAll(Wall.createCurve(curveBeginning, curveEnding, curveControlPoint, 100));

    }


    @Override
    public AbstractLevel getNextLevel() {
        return new Level2(this.gameWorld);
    }

    // -------------------------------- \\
    // --- Fin de la classe Level 1 --- \\
    // -------------------------------- \\
}
