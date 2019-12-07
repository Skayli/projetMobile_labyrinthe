package com.mygdx.game.model.ball;

import com.mygdx.game.model.color.Color;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe abstraite représentant soit une bille controlée par le joueur, soit une bille du canon
 */
public abstract class AbstractBall {

    protected double weight;
    protected int diameter;
    protected Vecteur position;
    protected Vecteur velocity;
    protected Color color;

    public AbstractBall(Vecteur position, int diameter, double weight, Color color) {
        this.position = position;
        this.diameter = diameter;
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

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public Vecteur getPosition() {
        return position;
    }

    public void setPosition(Vecteur position) {
        this.position = position;
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
