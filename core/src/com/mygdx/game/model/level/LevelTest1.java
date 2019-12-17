package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Target;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.level.levelComponent.LevelComponentWall;

import java.util.ArrayList;

import mesmaths.geometrie.base.Vecteur;

public class LevelTest1 extends AbstractLevel {


    public LevelTest1(GameWorld gameWorld)
    {
        super(gameWorld);

        ArrayList<Wall> walls = new ArrayList<Wall>();

        //Positionnement de la bille
        this.initialBallPosition = new Vecteur(1250, 6500);
        gameWorld.getBall().setPosition(this.initialBallPosition);

        double precision = 5;

        //Création des murs du level test 1
        // wall gauche
        walls.add(Wall.createWall(500,500, 500, 7000));
        // wall haut
        walls.add(Wall.createWall(500, 7000, 11500, 7000));
        // wall bas
        walls.add(Wall.createWall(500, 500, 11500, 500));
        // wall droite
        walls.add(Wall.createWall(11500, 500, 11500, 7000));
        // wall vide 1 - bas
        walls.add(Wall.createWall(1750, 1750, 10250, 1750));
        // wall vide 1 - haut
        walls.add(Wall.createWall(1750, 2250, 10250, 2250));
        // wall vide 1 - coté
        walls.add(Wall.createWall(10250, 1750, 10250, 2250));
        // wall gauche interne
        walls.add(Wall.createWall(1750, 1750, 1750, 7000));
        // wall vide 2 - coté
        walls.add(Wall.createWall(3000, 3500, 3000, 4000));
        // wall vide 2 - bas
        walls.add(Wall.createWall(3000, 3500, 11500, 3500));
        // wall vide 2 - haut
        walls.add(Wall.createWall(3000, 4000, 11500, 4000));
        // wall vide 3 - bas
        walls.add(Wall.createWall(1750, 5250, 10250, 5250));
        // wall vide 3 - haut
        walls.add(Wall.createWall(1750, 5750, 10250, 5750));
        // wall vide 3 - bas
        walls.add(Wall.createWall(10250, 5250, 10250, 5750));

        this.target = new Target(1750,5750,1250,1250);

        // Définition du LevelComponent
        this.levelComponent = new LevelComponentWall(this, walls);
    }

    @Override
    public AbstractLevel getNextLevel() {
        return new Level3(this.gameWorld);
    }
}
