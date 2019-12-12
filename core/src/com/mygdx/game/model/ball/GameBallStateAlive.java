package com.mygdx.game.model.ball;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.MaCollision;
import com.mygdx.game.model.Wall;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * Classe GameBallStateAlive héritant de GameBallState
 * Représente l'état où la gameBall est en jeu et peut bouger
 */
public class GameBallStateAlive extends GameBallState {

    public GameBallStateAlive(GameBall ball)
    {
        super(ball);
    }

    @Override
    public void update()
    {
        double accelX = Gdx.input.getAccelerometerY();
        double accelY = -Gdx.input.getAccelerometerX();

        Vecteur acceleration = new Vecteur(accelX, accelY);

        Cinematique.mouvementUniformémentAccéléré(this.gameBall.position, this.gameBall.velocity, acceleration, 1);
        this.gameBall.velocity.ajoute(MecaniquePoint.freinageFrottement(this.gameBall.weight, this.gameBall.velocity));	//ajout des frottements

        for(Wall wall : this.gameBall.game.getCurrentLevel().getWalls()) {
            MaCollision.collisionBilleSegment(this.gameBall, wall);
        }
        for(Hole hole: this.gameBall.game.getCurrentLevel().getHoles())
        {
            if (MaCollision.collisionHole(this.gameBall, hole))
            {
                this.gameBall.setCurrentGameBallState(this.gameBall.getGameBallStateDead());
            }
        }
    }
}
