package com.mygdx.game.model.ball;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.cannon.Cannon;
import com.mygdx.game.model.color.Color;

import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

/**
 * Classe représentant les billes tirées par le canon
 */
public class CannonBall extends AbstractBall {

    private int timeToLive;
    private int timeLived;
    private Cannon cannon;


    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    public CannonBall(GameWorld game, Cannon cannon, Vecteur position) {
        super(game, position, 100, 250, Color.RED());
        this.cannon = cannon;
        timeToLive = 180;
        timeLived = 0;
    }

    @Override
    public void update() {
        Cinematique.mouvementUniformémentAccéléré(this.getPosition(), this.getVelocity(), new Vecteur(0, 0), 1);
        this.getVelocity().ajoute(MecaniquePoint.freinageFrottement(this.getWeight(), this.getVelocity()));    //ajout des frottements

        timeLived++;
        if (timeLived > timeToLive) {
            this.cannon.getCannonBalls().remove(this);
        }

        Collisions.CollisionBilleBille(game.getBall().getPosition(), game.getBall().getRadius(), game.getBall().getVelocity(), game.getBall().getWeight(), this.position, this.radius, this.velocity, this.weight/5);
    }

    // ---------------------------------- \\
    // --- Fin de la class CannonBall --- \\
    // ---------------------------------- \\
}
