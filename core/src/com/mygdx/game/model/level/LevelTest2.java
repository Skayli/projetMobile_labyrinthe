package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Target;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.level.levelComponent.LevelComponentWall;

import java.util.ArrayList;

import mesmaths.geometrie.base.Vecteur;

public class LevelTest2 extends AbstractLevel {

    public LevelTest2(GameWorld gameWorld)
    {
        super(gameWorld);

        ArrayList<Wall> walls = new ArrayList<Wall>();

        //Positionnement de la bille
        this.initialBallPosition = new Vecteur(1250, 6500);
        gameWorld.getBall().setPosition(this.initialBallPosition);

        double precision = 10;

        //Création des murs du level 2
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
        // mur droite
//        walls.add(Wall.createWall(11500, 3500, 11500, 6500));
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
        // wall vide 1 - coté
//        walls.add(Wall.createWall(10250, 1750, 10250, 2250));
        // curve vide 1 bas gauche
        walls.addAll(Wall.createCurve(new Vecteur(1750,2750), new Vecteur(2750,1750), new Vecteur(1750,1750), precision));
        // curve vide 1 haut gauche
        walls.addAll(Wall.createCurve(new Vecteur(2750,2250), new Vecteur(1750,3250), new Vecteur(1750,2250), precision));
        // curve vide 1 cote bas
        walls.addAll(Wall.createCurve(new Vecteur(9750,1750), new Vecteur(10250,2000), new Vecteur(10250,1750), precision));
        // curve vide 1 cote haut
        walls.addAll(Wall.createCurve(new Vecteur(9750,2250), new Vecteur(10250,2000), new Vecteur(10250,2250), precision));

        // wall gauche interne
        walls.add(Wall.createWall(1750, 2750, 1750, 7000));

        // wall vide 2 - coté
        walls.add(Wall.createWall(3000, 3500, 3000, 4000));
        // wall vide 2 - bas
        walls.add(Wall.createWall(3000, 3500, 10000, 3500));
        // wall vide 2 - haut
        walls.add(Wall.createWall(3000, 4000, 10000, 4000));

        // wall vide 3 - bas
        walls.add(Wall.createWall(1750, 5250, 10250, 5250));
        // wall vide 3 - haut
        walls.add(Wall.createWall(1750, 5750, 10250, 5750));
        // wall vide 3 - bas
        walls.add(Wall.createWall(10250, 5250, 10250, 5750));

        this.target = new Target(1750,5750,1250,1250);

        // Définition du LevelComponent
        this.levelComponent = new LevelComponentWall(this, walls);

//        walls.add(Wall.createWall(500,2000, 500, 6500));
//        walls.addAll(Wall.createCurve(new Vecteur(500,2000), new Vecteur(2000,500), new Vecteur(500,500), precision));
//        walls.addAll(Wall.createCurve(new Vecteur(500,6500), new Vecteur(1250,7000), new Vecteur(500,7000), precision));
//        walls.addAll(Wall.createCurve(new Vecteur(1250,7000), new Vecteur(2000,6500), new Vecteur(2000,7000),precision));
//        walls.add(Wall.createWall(2000, 6500, 2000,2500));
//        walls.addAll(Wall.createCurve(new Vecteur(2500,2000), new Vecteur(2000,2500), new Vecteur(2000,2000), precision));
//        walls.add(Wall.createWall(2500,2000, 9500, 2000));
//        walls.add(Wall.createWall(2000,500, 10000,500));
//        walls.addAll(Wall.createCurve(new Vecteur(10000,500), new Vecteur(11500,2000), new Vecteur(11500,500), precision));
//        walls.addAll(Wall.createCurve(new Vecteur(11500,2000), new Vecteur(10000,3500), new Vecteur(11500,3500), precision));
//        walls.add(Wall.createWall(10000,3500,3500,3500));
//        walls.add(Wall.createWall(2000,5000,9500,5000));
//        walls.addAll(Wall.createCurve(new Vecteur(2500,5000), new Vecteur(2000,4500), new Vecteur(2000,5000),precision));
//        walls.addAll(Wall.createCurve(new Vecteur(10000,3500), new Vecteur(11500,5000), new Vecteur(11500,3500),precision));
//        walls.addAll(Wall.createCurve(new Vecteur(11500,5000), new Vecteur(10000,6500), new Vecteur(11500,6500), precision));
//        walls.add(Wall.createWall(10000,6500,2000, 6500));
    }

    @Override
    public AbstractLevel getNextLevel() {
        return new Level3(this.gameWorld);
    }
}
