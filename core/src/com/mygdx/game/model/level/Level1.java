package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;

/**
 * Classe représentant le level 1
 */
public class Level1 extends AbstractLevel{

    public Level1(GameWorld gameWorld) {
        super(gameWorld);

        //Positionnement de la bille

        //Création des murs du level 1

    }


    @Override
    public AbstractLevel getNextLevel() {
        return new Level2(this.gameWorld);
    }

    // -------------------------------- \\
    // --- Fin de la classe Level 1 --- \\
    // -------------------------------- \\
}
