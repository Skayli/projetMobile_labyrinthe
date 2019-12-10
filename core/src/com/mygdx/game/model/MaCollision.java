package com.mygdx.game.model;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

import mesmaths.geometrie.base.Matrice;
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
    public static boolean collisionBilleSegmentAvecRebond(Vecteur position, double rayon, Vecteur vitesse, final Vecteur P0, final Vecteur P1)
    {
        Vecteur[] base = base( P0,  P1);
        Vecteur N = base[1];

        Vector2 nearestPoint = new Vector2();
        Intersector.nearestSegmentPoint((float) P0.x, (float) P0.y, (float) P1.x, (float) P1.y, (float) position.x, (float) position.y, nearestPoint);

        Vecteur pointLePlusProche = new Vecteur(nearestPoint.x, nearestPoint.y);

        double distCarre = distCarre(position, pointLePlusProche);

        if(distCarre > (rayon)*(rayon) ) {
            return false;
        }

        Vecteur dir = new Vecteur(position.x - pointLePlusProche.x, position.y - pointLePlusProche.y);
        double angle = Vecteur.angleOrienté(dir, position);
        Vecteur nextPos = move(position, angle, rayon - Math.sqrt(distCarre(position, pointLePlusProche)));

        double distanceSignée = position.difference(P0).produitScalaire(N);

        if (distanceSignée >= rayon)  return false; // il n'y a pas collision entre la bille (position,rayon) et le segment [P0P1]
        System.out.println("COLLISION");
        double vN = vitesse.produitScalaire(N);

//        if (vN >= 0) {
//            System.out.println("La bille ressort");
//            return false; // la bille est à l'extérieur et revient vers le cadre ou est à l'intérieur et s'éloigne du bord
//        }


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

    public static double distCarre(Vecteur v1, Vecteur v2) {
        return (v2.x - v1.x) * (v2.x - v1.x) + (v2.y - v1.y) * (v2.y - v1.y);
    }

    public static Vecteur move(Vecteur point, double angle, double distance) {
        double x = point.x;
        double y = point.y;
        double rad = (angle) * (Math.PI / 180); // Convert to radians

        x += distance * Math.sin(rad);
        y += distance * Math.cos(rad);

        return new Vecteur(x,y);
    }
}
