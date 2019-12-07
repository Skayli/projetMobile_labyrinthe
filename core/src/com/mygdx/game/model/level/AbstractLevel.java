package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.wall.AbstractWall;
import java.util.ArrayList;

/**
 * Classe abstraite représentant un level
 */
public abstract class AbstractLevel implements iLevelState {

    protected GameWorld gameWorld; // sert à initialiser la position de la bille à chaque niveau
    protected ArrayList<AbstractWall> walls; // liste des murs
    protected ArrayList<Hole> holes; // liste des trous


    public AbstractLevel(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        this.walls = new ArrayList<>();
        this.holes = new ArrayList<>();
    }

    // fonction d'update, surtout utile pour le level 3 et mettre à jour le canon
    public void update() { }

    // --------------- \\
    // --- Getters --- \\
    // --------------- \\

    public ArrayList<AbstractWall> getWalls() {
        return walls;
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }

    // ------------------------------------- \\
    // --- Fin de la class AbstractLevel --- \\
    // ------------------------------------- \\
}
