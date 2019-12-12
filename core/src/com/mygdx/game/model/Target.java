package com.mygdx.game.model;

import com.mygdx.game.model.color.Color;

import mesmaths.geometrie.base.Vecteur;

/**
 * Représente l'arrivée : c'est un rectangle
 */
public class Target {

    Vecteur bottomLeft;
    double width;
    double height;

    Color color = Color.GREEN();

    //Constructeurs

    /**
     * Cible du labyrinthe à atteindre pour accéder au niveau suivant sous forme d'un rectangle
     * @param bottomLeft Coin haut gauche du rectangle
     * @param width largeur
     * @param height hauteur
     */
    public Target(Vecteur bottomLeft, double width, double height) {
        this.bottomLeft = bottomLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Cible du labyrinthe à atteindre pour accéder au niveau suivant sous forme d'un rectangle
     * @param bottomLeftX abscisse du point bas gauche
     * @param bottomLeftY ordonnée du point bas gauche
     * @param width largeur
     * @param height hauteur
     */
    public Target(double bottomLeftX, double bottomLeftY, double width, double height) {
        this.bottomLeft = new Vecteur(bottomLeftX, bottomLeftY);
        this.width = width;
        this.height = height;
    }

    //Getters & setters

    public Vecteur getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Vecteur bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
