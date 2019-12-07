package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;

/**
 * Classe représentant le level 2
 */
public class Level2 extends AbstractLevel {

    public Level2(GameWorld gameWorld) {
        super(gameWorld);

        //Positionnement de la bille

        //Création des murs du level 2

    }


    @Override
    public AbstractLevel getNextLevel() {
        return new Level3(gameWorld);
    }

    // -------------------------------- \\
    // --- Fin de la classe Level 2 --- \\
    // -------------------------------- \\
}
