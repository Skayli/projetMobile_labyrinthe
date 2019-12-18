package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.Target;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.level.levelComponent.LevelComponentHole;
import com.mygdx.game.model.level.levelComponent.LevelComponentWall;

import java.util.ArrayList;

import mesmaths.geometrie.base.Vecteur;

public class LevelTest3 extends AbstractLevel {

    public LevelTest3(GameWorld gameWorld)
    {
        super(gameWorld);

        ArrayList<Wall> walls = new ArrayList<Wall>();

        //Positionnement de la bille
        this.initialBallPosition = new Vecteur(1250, 6500);
        gameWorld.getBall().setPosition(this.initialBallPosition);

        double precision = 50;

        //Création des murs du level Test 2
        // mur gauche
        walls.add(Wall.createWall(500,2000, 500, 6500));
        // mur haut
        walls.add(Wall.createWall(1000, 7000, 10000, 7000));
        // mur bas
        walls.add(Wall.createWall(2000, 500, 10000, 500));
        // curve bas gauche
        walls.addAll(Wall.createCurve(new Vecteur(500,2000), new Vecteur(2000,500), new Vecteur(500,500), precision));
        // curve haut gauche
        walls.addAll(Wall.createCurve(new Vecteur(500,6500), new Vecteur(1000,7000), new Vecteur(500,7000), precision));
        // curve bas droit - bas
        walls.addAll(Wall.createCurve(new Vecteur(10000,500), new Vecteur(11500,2000), new Vecteur(11500,500), precision));
        // curve bas droit - haut
        walls.addAll(Wall.createCurve(new Vecteur(11500,2000), new Vecteur(10000,3500), new Vecteur(11500,3500), precision));
        // curve haut droit - bas
        walls.addAll(Wall.createCurve(new Vecteur(10000,4000), new Vecteur(11500,5500), new Vecteur(11500,4000), precision));
        // curve haut droit - haut
        walls.addAll(Wall.createCurve(new Vecteur(10000,7000), new Vecteur(11500,5500), new Vecteur(11500,7000), precision));

        // wall vide 1 - bas
        walls.add(Wall.createWall(2750, 1750, 9750, 1750));
        // wall vide 1 - haut
        walls.add(Wall.createWall(2750, 2250, 9750, 2250));
        // curve vide 1 bas gauche
        walls.addAll(Wall.createCurve(new Vecteur(1750,2750), new Vecteur(2750,1750), new Vecteur(1750,1750), precision));
        // curve vide 1 haut gauche
        walls.addAll(Wall.createCurve(new Vecteur(2750,2250), new Vecteur(1750,3250), new Vecteur(1750,2250), precision));
        // curve vide 1 cote
//        walls.addAll(Wall.createCurve(new Vecteur(9750,1750), new Vecteur(9750,2250), new Vecteur(10375,2000), precision));
        // curve vide 1 cote bas
        walls.addAll(Wall.createCurve(new Vecteur(9750,1750), new Vecteur(10250,2000), new Vecteur(10250,1750), precision));
        // curve vide 1 cote haut
        walls.addAll(Wall.createCurve(new Vecteur(9750,2250), new Vecteur(10250,2000), new Vecteur(10250,2250), precision));

        // wall gauche interne
        walls.add(Wall.createWall(1750, 2750, 1750, 7000));

        // wall vide 2 - bas
        walls.add(Wall.createWall(3500, 3500, 10000, 3500));
        // wall vide 2 - haut
        walls.add(Wall.createWall(3500, 4000, 10000, 4000));
        // curve vide 2 - cote haut
        walls.addAll(Wall.createCurve(new Vecteur(3500,4000), new Vecteur(3000,3750), new Vecteur(3000,4000), precision));
        // curve vide 2 - cote bas
        walls.addAll(Wall.createCurve(new Vecteur(3500,3500), new Vecteur(3000,3750), new Vecteur(3000,3500), precision));

        // wall vide 3 - bas
        walls.add(Wall.createWall(2750, 5250, 9750, 5250));
        // wall vide 3 - haut
        walls.add(Wall.createWall(1750, 5750, 9750, 5750));
        // curve vide 3 - bas gauche
        walls.addAll(Wall.createCurve(new Vecteur(1750,4250), new Vecteur(2750,5250), new Vecteur(1750,5250), precision));
        // curve vide 3 - cote haut
        walls.addAll(Wall.createCurve(new Vecteur(9750,5750), new Vecteur(10250,5500), new Vecteur(10250,5750), precision));
        // curve vide 3 - cote bas
        walls.addAll(Wall.createCurve(new Vecteur(9750,5250), new Vecteur(10250,5500), new Vecteur(10250,5250), precision));

        this.target = new Target(1750,5750,1250,1250);

        // Définition du LevelComponent
        this.levelComponent = new LevelComponentWall(this, walls);
//        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(3500,3500,750));
//        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(10000,2000,750));
//        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(10000,5000,750));
//        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(5000,1600,400));
//        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(7500,900,400));
//        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(5000,5400,400));
//        this.levelComponent = new LevelComponentHole(this.levelComponent, this, new Hole(7500,6100,400));
    }

    @Override
    public AbstractLevel getNextLevel() {
        return new LevelTest1(this.gameWorld);
    }
}
