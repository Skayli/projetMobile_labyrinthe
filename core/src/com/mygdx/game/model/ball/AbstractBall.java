package com.mygdx.game.model.ball;

import com.badlogic.gdx.Game;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.color.Color;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe abstraite représentant soit une bille controlée par le joueur, soit une bille du canon
 */
public abstract class AbstractBall {

    protected double weight;
    protected double radius;
    protected Vecteur position;
    protected Vecteur velocity;
    protected Color color;
    protected GameWorld game;

    public AbstractBall(GameWorld game, Vecteur position, double radius, double weight, Color color) {
        this.game = game;
        this.position = position;
        this.radius = radius;
        this.weight = weight;
        this.velocity = new Vecteur(0,0);
        this.color = color;
    }

    // ------------------------------------------------------------------------------- \\
    // --- Fonction à surcharger pour le déplacement et les collisions d'une bille --- \\
    // ------------------------------------------------------------------------------- \\

    public abstract void update();

    // ------------------------- \\
    // --- Getters & setters --- \\
    // ------------------------- \\

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Vecteur getPosition() {
        return position;
    }

    public void setPosition(Vecteur position) {
        this.position = position;
    }

    public void setPosition(double x, double y) {
        this.position.x = x;
        this.position.y = y;
    }

    public Vecteur getVelocity() {
        return velocity;
    }

    public void setVelocity(Vecteur velocity) {
        this.velocity = velocity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // ------------------------------------ \\
    // --- Fin de la class AbstractBall --- \\
    // ------------------------------------ \\
}
