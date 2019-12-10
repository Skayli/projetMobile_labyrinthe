package com.mygdx.game.model.ball;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.MaCollision;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.color.Color;

import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * Classe représentant une bille de jeu (celle contrôlée par le joueur)
 */
public class GameBall extends AbstractBall {

    //Données relatives aux GameBall
    private static final int gameBallRadius = 250;
    private static final double gameBallWeight = 1000;
    private static final Color gameBallColor = Color.BLUE();

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\
    public GameBall(GameWorld game) {
        super(game, new Vecteur(0,0), gameBallRadius, gameBallWeight, gameBallColor);
        this.velocity.x = 0;
        this.velocity.y = 20;
    }

    public GameBall(GameWorld game, Vecteur position) {
        super(game, position, gameBallRadius, gameBallWeight, gameBallColor);
    }

    // Gestion du déplacement d'une GameBall
    @Override
    public void update() {
        double accelX = Gdx.input.getAccelerometerY();
        double accelY = -Gdx.input.getAccelerometerX();

        Vecteur acceleration = new Vecteur(accelX, accelY);

        Cinematique.mouvementUniformémentAccéléré(this.getPosition(), this.velocity, new Vecteur(0,0), 1);
        this.velocity.ajoute(MecaniquePoint.freinageFrottement(this.weight, this.velocity));	//ajout des frottements


        for(Wall wall : this.game.getCurrentLevel().getWalls()) {
            MaCollision.collisionBilleSegmentAvecRebond(this.getPosition(), this.getRadius(), this.getVelocity(), wall.getBeginning(), wall.getEnding());
        }
    }

    // -------------------------------- \\
    // --- Fin de la class GameBall --- \\
    // -------------------------------- \\
}
