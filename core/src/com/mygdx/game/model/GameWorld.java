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
        this.ball = new GameBall();
        this.currentLevel = new Level2(this);
    }

    public void update() {

        this.setChanged();
        this.notifyObservers(this);
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
