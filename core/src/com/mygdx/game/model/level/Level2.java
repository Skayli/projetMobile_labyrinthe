package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.Target;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.level.levelComponent.LevelComponentHole;
import com.mygdx.game.model.level.levelComponent.LevelComponentWall;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant le level 2
 */
public class Level2 extends AbstractLevel {

    public Level2(GameWorld gameWorld) {
        super(gameWorld);

        ArrayList<Wall> walls = new ArrayList<Wall>();

        //Positionnement de la bille
        this.initialBallPosition = new  Vecteur(1250, 6500);
        gameWorld.getBall().setPosition(this.initialBallPosition);

        double precision = 5;

        //Création des murs du level 2
        walls.add(Wall.createWall(500,2000, 500, 6500));
        walls.addAll(Wall.createCurve(new Vecteur(500,2000), new Vecteur(2000,500), new Vecteur(500,500), precision));
        walls.addAll(Wall.createCurve(new Vecteur(500,6500), new Vecteur(1250,7000), new Vecteur(500,7000), precision));
        walls.addAll(Wall.createCurve(new Vecteur(1250,7000), new Vecteur(2000,6500), new Vecteur(2000,7000),precision));
        walls.add(Wall.createWall(2000, 6500, 2000,2500));
        walls.addAll(Wall.createCurve(new Vecteur(2500,2000), new Vecteur(2000,2500), new Vecteur(2000,2000), precision));
        walls.add(Wall.createWall(2500,2000, 9500, 2000));
        walls.add(Wall.createWall(2000,500, 10000,500));
        walls.addAll(Wall.createCurve(new Vecteur(10000,500), new Vecteur(11500,2000), new Vecteur(11500,500), precision));
        walls.addAll(Wall.createCurve(new Vecteur(11500,2000), new Vecteur(10000,3500), new Vecteur(11500,3500), precision));
        walls.add(Wall.createWall(10000,3500,3500,3500));
        walls.add(Wall.createWall(2000,5000,9500,5000));
        walls.addAll(Wall.createCurve(new Vecteur(2500,5000), new Vecteur(2000,4500), new Vecteur(2000,5000),precision));
        walls.addAll(Wall.createCurve(new Vecteur(10000,3500), new Vecteur(11500,5000), new Vecteur(11500,3500),precision));
        walls.addAll(Wall.createCurve(new Vecteur(11500,5000), new Vecteur(10000,6500), new Vecteur(11500,6500), precision));
        walls.add(Wall.createWall(10000,6500,2000, 6500));

        // Définition du LevelComponent
        this.levelComponent = new LevelComponentWall(this, walls);
        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(3500,3500,750));
        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(10000,2000,750));
        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(10000,5000,750));
        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(5000,1600,400));
        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(7500,900,400));
        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(5000,5400,400));
        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(7500,6100,400));

        this.target = new Target(2000,5000,1500,1500);
    }


    @Override
    public AbstractLevel getNextLevel() {
        return new Level3(gameWorld);
    }

    // -------------------------------- \\
    // --- Fin de la classe Level 2 --- \\
    // -------------------------------- \\
}
