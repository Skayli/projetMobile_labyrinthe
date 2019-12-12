package com.mygdx.game.model.ball;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.MaCollision;
import com.mygdx.game.model.Wall;
import com.mygdx.game.model.color.Color;
import com.mygdx.game.model.sound.SoundManager;

import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * Classe représentant une bille de jeu (celle contrôlée par le joueur)
 */
public class GameBall extends AbstractBall {

    //Données relatives aux GameBall
    public static final int gameBallRadius = 250;
    private static final double gameBallWeight = 75;
    private static final Color gameBallColor = Color.BLUE();
    private boolean isDead = false;

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\
    public GameBall(GameWorld game) {
        super(game, new Vecteur(0,0), gameBallRadius, gameBallWeight, gameBallColor);
    }

    public GameBall(GameWorld game, Vecteur position) {
        super(game, position, gameBallRadius, gameBallWeight, gameBallColor);
    }

    // Gestion du déplacement d'une GameBall
    @Override
    public void update() {
        if (!isDead)
        {
            double accelX = Gdx.input.getAccelerometerY();
            double accelY = -Gdx.input.getAccelerometerX();

            Vecteur acceleration = new Vecteur(accelX, accelY);

            Cinematique.mouvementUniformémentAccéléré(this.position, this.velocity, acceleration, 1);
            this.velocity.ajoute(MecaniquePoint.freinageFrottement(this.weight, this.velocity));	//ajout des frottements

            for(Wall wall : this.game.getCurrentLevel().getWalls()) {
                MaCollision.collisionBilleSegment(this, wall);
            }
            for(Hole hole: this.game.getCurrentLevel().getHoles())
            {
                if (MaCollision.collisionHole(this, hole))
                {
                    isDead = true;
                }
            }
        }
        else
        {
            this.setRadius(radius-1);

            Cinematique.mouvementUniformémentAccéléré(this.position, this.velocity, new Vecteur(0,0), 1);
            this.velocity.ajoute(MecaniquePoint.freinageFrottement(this.weight/5, this.velocity));	//ajout des frottements + up du poids car dans trou

            for(Wall wall : this.game.getCurrentLevel().getWalls()) {
                MaCollision.collisionBilleSegment(this, wall);
            }
            if (radius <= 0)
            {
                this.game.getCurrentLevel().resetBallPosition();
                isDead = false;
                this.setColor(Color.BLUE());
            }
        }
    }

    // -------------------------------- \\
    // --- Fin de la class GameBall --- \\
    // -------------------------------- \\
}
