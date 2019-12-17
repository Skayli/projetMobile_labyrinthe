package com.mygdx.game.model.cannon;

import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.ball.CannonBall;
import com.mygdx.game.model.cannon.CannonStates.CannonState;
import com.mygdx.game.model.cannon.CannonStates.CannonStateLeft;
import com.mygdx.game.model.cannon.CannonStates.CannonStateRight;
import com.mygdx.game.model.sound.SoundManager;

import java.util.ArrayList;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant le canon du level 3 des petites billes sur la bille contrôlée par le joueur
 */
public class Cannon {

    private GameWorld game;

    private double angle;
    private Vecteur position;
    private ArrayList<CannonBall> cannonBalls;

    private double seuilLeft;
    private double seuilRight;

    private int seuilShotMin;
    private int seuilShotMax;
    private int currentShotSeuil;
    private int timer;

    private double turningSpeed;

    private CannonState currentState, stateTurnRight, stateTurnLeft;

    /**
     * !!! ATTENTION !!! => a voir : gestion de la bille de canon (1 seule bille, tableau de bille, etc ...)
     */

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    public Cannon(GameWorld game, Vecteur position, double initialAngle, int seuilLeft, int seuilRight, int seuilShotMin, int seuilShotMax, boolean startTurningRight, double turningSpeed) {
        this.game = game;
        this.position = position;
        this.angle = initialAngle;
        this.seuilLeft = seuilLeft;
        this.seuilRight = seuilRight;
        initStates(startTurningRight);

        this.seuilShotMax = seuilShotMax;
        this.seuilShotMin = seuilShotMin;

        setNewSeuil();
        this.timer = 0;

        this.cannonBalls = new ArrayList<>();

        this.turningSpeed = turningSpeed;
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

        for(CannonBall cannonBall : cannonBalls) {
            cannonBall.update();
        }

        timer++;
        if(timer > currentShotSeuil) {
            //Ajout d'une cannonBall dans la liste
            CannonBall cannonBall = new CannonBall(game, this, this.position.copie());
            double radian = angle * Math.PI / 180;
            Vecteur dir = new Vecteur(Math.cos(radian), Math.sin(radian));
            cannonBall.setVelocity(dir);
            double multVelocity = Math.random() * (150-90) + 90;
            cannonBall.getVelocity().multiplie(multVelocity);

            cannonBalls.add(cannonBall);

            SoundManager.getInstance().play(SoundManager.cannon_shot, .2f);
            timer = 0;
            setNewSeuil();
        }
    }

    private void setNewSeuil() {
        currentShotSeuil = (int)  (Math.random() * (seuilShotMax - seuilShotMin) + seuilShotMin);
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

    public ArrayList<CannonBall> getCannonBalls() {
        return cannonBalls;
    }

    public void setCannonBalls(ArrayList<CannonBall> cannonBalls) {
        this.cannonBalls = cannonBalls;
    }

    public double getTurningSpeed() {
        return turningSpeed;
    }

    public void setTurningSpeed(double turningSpeed) {
        this.turningSpeed = turningSpeed;
    }

    // ------------------------------ \\
    // --- Fin de la class Cannon --- \\
    // ------------------------------ \\
}
