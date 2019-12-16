package com.mygdx.game.model.ball.GameBallStates;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.MaCollision;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.ball.GameBall;
import com.mygdx.game.model.sound.SoundManager;

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

        Cinematique.mouvementUniformémentAccéléré(this.gameBall.getPosition(), this.gameBall.getVelocity(), acceleration, 1);
        this.gameBall.getVelocity().ajoute(MecaniquePoint.freinageFrottement(this.gameBall.getWeight(), this.gameBall.getVelocity()));	//ajout des frottements

//        for(Wall wall : this.gameBall.getGame().getCurrentLevel().getWalls()) {
//            MaCollision.collisionBilleSegment(this.gameBall, wall);
//        }
//        for(Hole hole: this.gameBall.getGame().getCurrentLevel().getHoles())
//        {
//            if (MaCollision.collisionHole(this.gameBall, hole))
//            {
//                SoundManager.getInstance().play(SoundManager.death, .5f);
//                this.gameBall.setCurrentGameBallState(this.gameBall.getGameBallStateDead());
//            }
//        }
    }
}
