package com.mygdx.game.model.level;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Target;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.level.levelComponent.LevelComponentWall;

import java.util.ArrayList;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant le level 1
 */
public class Level1 extends AbstractLevel{

    public Level1(GameWorld gameWorld) {
        super(gameWorld);

        ArrayList<Wall> walls = new ArrayList<Wall>();

        //Positionnement de la bille
        this.initialBallPosition = new  Vecteur(1250, 6500);
        gameWorld.getBall().setPosition(this.initialBallPosition);

        //Création des murs du level 1
        walls.add(Wall.createWall(500,500, 500, 7000));
        walls.add(Wall.createWall(500, 7000, 2000, 7000));
        walls.add(Wall.createWall(2000, 7000, 2000,2000));
        walls.add(Wall.createWall(2000,2000, 9500, 2000));
        walls.add(Wall.createWall(500,500, 11500,500));
        walls.add(Wall.createWall(11500,500, 11500,3500));
        walls.add(Wall.createWall(11500,3500,3500,3500));
        walls.add(Wall.createWall(2000,5000,9500,5000));
        walls.add(Wall.createWall(11500,3500,11500,6500));
        walls.add(Wall.createWall(11500,6500,2000, 6500));

        this.levelComponent = new LevelComponentWall(this, walls);

        this.target = new Target(2000,5000,1500,1500);
    }


    @Override
    public AbstractLevel getNextLevel() {
        return new Level2(this.gameWorld);
    }

    // -------------------------------- \\
    // --- Fin de la classe Level 1 --- \\
    // -------------------------------- \\
}
