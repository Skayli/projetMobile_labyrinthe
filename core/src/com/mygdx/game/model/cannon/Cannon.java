package com.mygdx.game.model.cannon;

import com.mygdx.game.model.ball.CannonBall;
import com.mygdx.game.model.cannon.CannonStates.CannonState;
import com.mygdx.game.model.cannon.CannonStates.CannonStateLeft;
import com.mygdx.game.model.cannon.CannonStates.CannonStateRight;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant le canon du level 3 des petites billes sur la bille contrôlée par le joueur
 */
public class Cannon {

    private double angle;
    private Vecteur position;
    private CannonBall cannonBall; // bille tirée par le canon

    private double seuilLeft;
    private double seuilRight;

    private int seuilShotMin;
    private int seuilShotMax;
    private int currentShotSeuil;
    private int timer;

    private CannonState currentState, stateTurnRight, stateTurnLeft;

    /**
     * !!! ATTENTION !!! => a voir : gestion de la bille de canon (1 seule bille, tableau de bille, etc ...)
     */

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    public Cannon(Vecteur position, double initialAngle, int seuilLeft, int seuilRight, int seuilShotMin, int seuilShotMax, boolean startTurningRight) {
        this.position = position;
        this.angle = initialAngle;
        this.seuilLeft = seuilLeft;
        this.seuilRight = seuilRight;
        initStates(startTurningRight);

        this.seuilShotMax = seuilShotMax;
        this.seuilShotMin = seuilShotMin;

        setNewSeuil();
        this.timer = 0;
    }

    private void initStates(boolean startTurningRight) {
        this.stateTurnLeft = new CannonStateLeft(this);
        this.stateTurnRight = new CannonStateRight(this);

        this.currentState = (startTurningRight ? stateTurnRight : stateTurnLeft);

    }

    // ----------------- \\
    // --- Fonctions --- \\
    // ----------------- \\

    public void update() {
        this.currentState.update();

        timer++;
        if(timer > currentShotSeuil) {
            System.out.println("SHOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOT");
            timer = 0;
            setNewSeuil();
        }
    }

    private void setNewSeuil() {
        currentShotSeuil = (int)  (Math.random() * (seuilShotMax - seuilShotMin) + seuilShotMin);
        System.out.println("Nouveau seuil de tir : " + currentShotSeuil);
    }

    // ------------------------- \\
    // --- Getters & setters --- \\
    // ------------------------- \\

    public Vecteur getPosition() {
        return position;
    }

    public void setPosition(Vecteur position) {
        this.position = position;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getSeuilLeft() {
        return seuilLeft;
    }

    public void setSeuilLeft(double seuilLeft) {
        this.seuilLeft = seuilLeft;
    }

    public double getSeuilRight() {
        return seuilRight;
    }

    public void setSeuilRight(double seuilRight) {
        this.seuilRight = seuilRight;
    }

    public CannonState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(CannonState currentState) {
        this.currentState = currentState;
    }

    public CannonState getStateTurnRight() {
        return stateTurnRight;
    }

    public void setStateTurnRight(CannonState stateTurnRight) {
        this.stateTurnRight = stateTurnRight;
    }

    public CannonState getStateTurnLeft() {
        return stateTurnLeft;
    }

    public void setStateTurnLeft(CannonState stateTurnLeft) {
        this.stateTurnLeft = stateTurnLeft;
    }

    // ------------------------------ \\
    // --- Fin de la class Cannon --- \\
    // ------------------------------ \\
}
