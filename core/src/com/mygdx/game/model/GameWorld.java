package com.mygdx.game.model;

import com.mygdx.game.model.ball.GameBall;
import com.mygdx.game.model.level.AbstractLevel;
import com.mygdx.game.model.level.Level1;
import com.mygdx.game.model.level.Level2;

import java.util.Observable;

/**
 * Class GameWorld
 * Décrit l'ensemble du jeu
 */
public class GameWorld extends Observable {

    public static final int WIDTH = 12000;
    public static final int HEIGHT = 7500;

    private GameBall ball;
    private AbstractLevel currentLevel;


    public GameWorld() {
        this.ball = new GameBall(this);
        this.currentLevel = new Level2(this);
    }

    public void update() {
        //Déplacement de la bille et gestion des collision et des trous
        this.ball.update();

        if(isLevelFinished()) {
            this.currentLevel = this.currentLevel.getNextLevel();
        }

        this.setChanged();
        this.notifyObservers(this);
    }

    private boolean isLevelFinished() {
        return MaCollision.isCircleInRectangle(ball.getPosition(), ball.getRadius(), this.currentLevel.getTarget().bottomLeft, this.currentLevel.getTarget().width, this.currentLevel.getTarget().height);
    }

    // --------------- \\
    // --- Getters --- \\
    // --------------- \\

    public GameBall getBall() {
        return ball;
    }

    public AbstractLevel getCurrentLevel() {
        return currentLevel;
    }

    // ---------------------------------- \\
    // --- Fin de la classe GameWorld --- \\
    // ---------------------------------- \\
}
