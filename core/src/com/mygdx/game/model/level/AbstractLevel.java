package com.mygdx.game.model.level;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.Target;
import com.mygdx.game.model.Wall;
import java.util.ArrayList;

/**
 * Classe abstraite représentant un level
 */
public abstract class AbstractLevel implements iLevelState {

    protected GameWorld gameWorld; // sert à initialiser la position de la bille à chaque niveau
    protected ArrayList<Wall> walls; // liste des murs
    protected ArrayList<Hole> holes; // liste des trous
    protected Target target; //Cible a atteindre


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

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public ArrayList<Hole> getHoles() {
        return holes;
    }

    public Target getTarget() {
        return target;
    }

    // ------------------------------------- \\
    // --- Fin de la class AbstractLevel --- \\
    // ------------------------------------- \\
}
