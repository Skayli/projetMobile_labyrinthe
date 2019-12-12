package com.mygdx.game.model.ball;

/**
 * Classe GameBallStateStatic héritant de GameBallState
 * Représente l'état où la gameBall est statique
 */
public class GameBallStateStatic extends GameBallState {

    public GameBallStateStatic(GameBall ball) {
        super(ball);
    }

    @Override
    public void update() {
        /**
         * Rien à faire car on veut que la bille reste immobile
         */
    }
}
