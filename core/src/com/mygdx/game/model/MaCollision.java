package com.mygdx.game.model;

import mesmaths.geometrie.base.Vecteur;

public class MaCollision {

    /**
     * gestion de la collision avec rebond de la bille définie par (position,rayon,vitesse) avec le segment orienté [P0P1]
     *
     * @return false si il n'y a pas de collision
     *
     * @return true si il y a collision et dans ce cas modifie vitesse
     *
     *
     * c-à-d que en entrée on considère que (position,vitesse) sont le vecteur position et le vecteur vitesse de la bille immédiatement avant le choc
     * et en sortie (position,vitesse) sont le vecteur position et le vecteur vitesse de la bille immédiatement après le choc
     *
     * le vecteur vitesse est modifié par la collision (comme une boule de billard l'est par une bande)
     * La méthode laisse le vecteur position intact
     * @param position : vecteur position de la bille immédiatement avant la collision avec le segment [P0P1]
     * @param rayon : rayon de la bille
     * @param vitesse : vecteur vitesse de la bille immédiatement avant la collision avec le segment [P0P1]
     * @param P0 : le début du segment
     * @param P1 : la fin du segment
     *
     * */
    public static boolean collisionBilleSegmentAvecRebond(final Vecteur position, double rayon, Vecteur vitesse, final Vecteur P0, final Vecteur P1)
    {
        Vecteur[] base = base( P0,  P1);
//Vecteur I = base[0];
        Vecteur N = base[1];



        double distanceSignée = position.difference(P0).produitScalaire(N);

        if (distanceSignée >= rayon)  return false; // il n'y a pas collision entre la bille (position,rayon) et le segment [P0P1]

        System.out.println("--------------------------------------------------");
        System.out.println("Position : " + position);
        System.out.println("Wall : " + P0 + " - " + P1);
        System.out.println("Distance : " + distanceSignée);
        System.out.println("Vecteur N : " + N);

        double vN = vitesse.produitScalaire(N);

        System.out.println("Vn : " +vN);

        if (vN >= 0) {
            System.out.println("La bille ressort");
            return false; // la bille est à l'extérieur et revient vers le cadre ou est à l'intérieur et s'éloigne du bord
        }

        System.out.println("La bille ne ressort pas");


// à présent distanceSignée < rayon et vN < 0

// -vN est l'intensité du choc !!!!

        Vecteur deltaV = N.produit(-2*vN);  // calcul du changement de trajectoire

        vitesse.ajoute(deltaV); // la bille rebondit

        return true;

    }                           // collisionBilleSegmentAvecRebond


    /**
     * fournit une base orthornormée directe associée au segment orienté [P0, P1]
     * base[0] est un vecteur unitaire colineaire et  de meme sens que le vecteur P0--->P1
     * et base[1] est tel que base[1] soit le résultat de la rotation d'angle de +PI/2 par rapport à base[0]
     *  @return un tableau t à deux éléments tel que t[0] == base[0] et que t[1] == base[1]
     * */
    public static Vecteur[] base(Vecteur P0, Vecteur P1)
    {
        return P1.difference(P0).base();
    }
}
