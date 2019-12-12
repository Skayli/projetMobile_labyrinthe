package com.mygdx.game.model.ball;

/**
 * Classe abstraite représentant l'état de la GameBall
 */
public abstract class GameBallState {

    protected GameBall gameBall;

    public GameBallState(GameBall ball)
    {
        this.gameBall = ball;
    }

    public GameBall getGameBall() {
        return gameBall;
    }

    public void setGameBall(GameBall gameBall) {
        this.gameBall = gameBall;
    }

    public abstract void update();
}
