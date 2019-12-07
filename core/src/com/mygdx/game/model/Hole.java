package com.mygdx.game.model;

import com.mygdx.game.model.color.Color;
import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant un trou dans lequel la bille peut tromber
 */
public class Hole {

    private Vecteur position;
    private int diameter;
    private Color color = Color.BLACK();

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    public Hole(double x, double y, int diameter) {
        this.position = new Vecteur(x, y);
        this.diameter = diameter;
    }

    public Hole(Vecteur position, int diameter) {
        this.position = position;
        this.diameter = diameter;
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

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    // ---------------------------- \\
    // --- Fin de la classe Hole -- \\
    // ---------------------------- \\
}
