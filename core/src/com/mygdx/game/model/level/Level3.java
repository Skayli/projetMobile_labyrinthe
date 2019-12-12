package com.mygdx.game.model.level;

import com.mygdx.game.model.Cannon;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Target;

/**
 * Classe représentant le level 3
 */
public class Level3 extends AbstractLevel {

    Cannon cannon;

    public Level3(GameWorld gameWorld) {
        super(gameWorld);

        //Positionnement de la bille
        gameWorld.getBall().setPosition(1250,GameWorld.HEIGHT-1000);

        //Création du canon
        this.cannon = new Cannon();

        //Construction des murs du level 3


        this.target = new Target(2000,5000,1500,1500);

    }

    public void update() {
        //Mise à jour du canon
        this.cannon.update();

    }

    @Override
    public AbstractLevel getNextLevel() {
        return new Level1(this.gameWorld);
    }

    // -------------------------------- \\
    // --- Fin de la classe Level 3 --- \\
    // -------------------------------- \\
}
