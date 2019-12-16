package com.mygdx.game.model.level;

import com.badlogic.gdx.Game;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.Target;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.ball.GameBall;
import com.mygdx.game.model.level.levelComponent.LevelComponent;

import java.util.ArrayList;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe abstraite représentant un level
 */
public abstract class AbstractLevel implements iLevelState {

    protected GameWorld gameWorld; // sert à initialiser la position de la bille à chaque niveau
    protected ArrayList<Wall> walls; // liste des murs
    protected ArrayList<Hole> holes; // liste des trous
    protected Vecteur initialBallPosition;
    protected Target target;
    protected LevelComponent levelComponent; // Définira les composants présents dans le niveau (murs, trous, canon, bombe atomique, etc)


    public AbstractLevel(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        this.walls = new ArrayList<>();
        this.holes = new ArrayList<>();

        this.gameWorld.getBall().resetVelocity();
    }

    // fonction d'update, surtout utile pour le level 3 et mettre à jour le canon
    public void update() { }

    public void resetBallPosition()
    {
        this.gameWorld.getBall().setPosition(initialBallPosition);
        this.gameWorld.getBall().getVelocity().x = 0;
        this.gameWorld.getBall().getVelocity().y = 0;
        this.gameWorld.getBall().setRadius(GameBall.gameBallRadius);
    }

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

    public GameWorld getGameWorld()
    {
        return this.gameWorld;
    }

    public LevelComponent getLevelComponent()
    {
        return this.levelComponent;
    }

    // ------------------------------------- \\
    // --- Fin de la class AbstractLevel --- \\
    // ------------------------------------- \\
}
