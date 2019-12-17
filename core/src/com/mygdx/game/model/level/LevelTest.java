package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Target;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.level.levelComponent.LevelComponentWall;

import java.util.ArrayList;

import mesmaths.geometrie.base.Vecteur;

public class LevelTest extends AbstractLevel {


    public LevelTest(GameWorld gameWorld)
    {
        super(gameWorld);

        ArrayList<Wall> walls = new ArrayList<Wall>();

        //Positionnement de la bille
        this.initialBallPosition = new Vecteur(1250, 6500);
        gameWorld.getBall().setPosition(this.initialBallPosition);

        double precision = 5;

        //Création des murs du level test
        walls.add(Wall.createWall(500,500, 500, 7000));
        walls.add(Wall.createWall(500, 7000, 2000, 7000));
//        walls.add(Wall.createWall(2000, 7000, 2000,2000));
//        walls.add(Wall.createWall(2000,2000, 9500, 2000));
//        walls.add(Wall.createWall(500,500, 11500,500));
//        walls.add(Wall.createWall(11500,500, 11500,3500));
//        walls.add(Wall.createWall(11500,3500,3500,3500));
//        walls.add(Wall.createWall(2000,5000,9500,5000));
//        walls.add(Wall.createWall(11500,3500,11500,6500));
//        walls.add(Wall.createWall(11500,6500,2000, 6500));
//        walls.add(Wall.createWall(10000,6500,2000, 6500));

        this.target = new Target(2000,5000,1500,1500);

        // Définition du LevelComponent
        this.levelComponent = new LevelComponentWall(this, walls);
    }

    @Override
    public AbstractLevel getNextLevel() {
        return new Level3(this.gameWorld);
    }
}
