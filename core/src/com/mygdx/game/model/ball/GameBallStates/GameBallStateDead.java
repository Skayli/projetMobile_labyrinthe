package com.mygdx.game.model.ball.GameBallStates;

import com.mygdx.game.model.MaCollision;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.ball.GameBall;
import com.mygdx.game.model.ball.GameBallState;
import com.mygdx.game.model.color.Color;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * Classe GameBallStateDead héritant de GameBallState
 * Représente l'état où la gameBall est tombée dans un trou
 * La gameBall est donc présentemment dans un état de décès
 */
public class GameBallStateDead extends GameBallState {

    public GameBallStateDead(GameBall ball) {
        super(ball);
    }

    @Override
    public void update() {
        this.gameBall.setRadius(this.gameBall.getRadius()-2.5);

        Cinematique.mouvementUniformémentAccéléré(this.gameBall.getPosition(), this.gameBall.getVelocity(), new Vecteur(0,0), 1);
        this.gameBall.getVelocity().ajoute(MecaniquePoint.freinageFrottement(this.gameBall.getWeight()/5, this.gameBall.getVelocity()));	//ajout des frottements + up du poids car dans trou

        for(Wall wall : this.gameBall.getGame().getCurrentLevel().getWalls()) {
            MaCollision.collisionBilleSegment(this.gameBall, wall);
        }
        if (this.gameBall.getRadius() <= 0)
        {
            this.gameBall.getGame().getCurrentLevel().resetBallPosition();
            this.gameBall.setColor(Color.BLUE());
            this.gameBall.setCurrentGameBallState(this.gameBall.getGameBallStateAlive());
        }
    }
}
