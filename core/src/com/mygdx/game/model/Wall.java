package com.mygdx.game.model;

import java.util.ArrayList;

import mesmaths.geometrie.base.Vecteur;

/**
 * Classe représentant les murs d'un level
 */
public class Wall {

    private Vecteur beginning;
    private Vecteur ending;

    // --------------------- \\
    // --- Constructeurs --- \\
    // --------------------- \\

    private Wall(double beginningX, double beginningY, double endingX, double endingY) {
        this.beginning = new Vecteur(beginningX, beginningY);
        this.ending = new Vecteur(endingX, endingY);
    }

    private Wall(Vecteur beginning, Vecteur ending) {
        this.beginning = beginning;
        this.ending = ending;
    }

    public static ArrayList<Wall> createCurve(Vecteur beginning, Vecteur ending, Vecteur controlPoint, double precision) {
        ArrayList<Wall> curve = new ArrayList<>();
        double tVariation = (double) 1/precision;

        Vecteur previousPoint = beginning;

        for(double t = 0; t < 1; t = t+tVariation) {
            double pointX = bezierEquation(beginning.x, controlPoint.x, ending.x, t);
            double pointY = bezierEquation(beginning.y, controlPoint.y, ending.y, t);

            Vecteur nextPoint = new Vecteur(pointX, pointY);
            curve.add(new Wall(previousPoint, nextPoint));

            previousPoint = nextPoint;
        }

        curve.add(new Wall(previousPoint, ending));

        return curve;
    }

    private static double bezierEquation(double p0, double p1, double p2, double t) {
        return ( ((1-t) * (1-t) * p0) + (2 * (1 - t) * t * p1) + (t * t * p2) );
    }

    // --------------- \\
    // --- Getters --- \\
    // --------------- \\

    public Vecteur getBeginning() {
        return beginning;
    }

    public Vecteur getEnding() {
        return ending;
    }


    // ------------------------------------- \\
    // --- Fin de la classe Wall --- \\
    // ------------------------------------- \\
}
