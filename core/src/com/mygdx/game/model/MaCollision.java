package com.mygdx.game.model;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.ball.AbstractBall;
import com.mygdx.game.model.ball.GameBall;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import mesmaths.geometrie.base.Matrice;
import mesmaths.geometrie.base.Vecteur;

public class MaCollision {

    public static boolean collisionBilleSegment(AbstractBall ball, Wall wall) {
        if(collisionSegment(ball, wall)) {
            Vecteur projection = projectionI(ball, wall);
            Vecteur normale = getNormale(ball, wall);
            Vecteur rebond = calculerVecteurV2(ball.getVelocity(), normale);

            System.out.println("normale : " + normale);

            System.out.println("Ball : " + ball.getPosition());
            System.out.println("Wall : " + wall.getBeginning() + " - " + wall.getEnding());


            ball.setVelocity(rebond);
            System.out.println("COLLISION");
            System.out.println("Rebond : " + rebond);

            //rayon.ci * vecteur divisé par norme
            Vecteur dir = new Vecteur(ball.getPosition().x - projection.x, ball.getPosition().y - projection.y);
            double normeDir = dir.norme();
            dir.x /= normeDir;
            dir.y /= normeDir;

            dir.multiplie(ball.getRadius() - Math.sqrt(distCarre(ball.getPosition(), projection)));

            System.out.println("Ancienne position BILLE : " + ball.getPosition());
            //Nouveau centre = ancien centre + dir*rayon-CI
            ball.setPosition(ball.getPosition().somme(dir));
            System.out.println("Nouvelle position BILLE : " + ball.getPosition());

            return true;
        }

        System.out.println("PAS DE COLLISION");

        return false;
    }

    public static boolean collisionSegment(AbstractBall ball, Wall wall) {
        if(!collisionDroite(ball, wall)) {
            return false;
        }

        Vecteur AB, AC, BC;
        AB = new Vecteur(wall.getEnding().x - wall.getBeginning().x, wall.getEnding().y - wall.getBeginning().y);
        AC = new Vecteur(ball.getPosition().x - wall.getBeginning().x, ball.getPosition().y - wall.getBeginning().y);
        BC = new Vecteur(ball.getPosition().x - wall.getEnding().x, ball.getPosition().y - wall.getEnding().y);

        double pscal1 = AB.x*AC.x + AB.y*AC.y;  // produit scalaire
        double pscal2 = (-AB.x)*BC.x + (-AB.y)*BC.y;  // produit scalaire
        if (pscal1>=0 && pscal2>=0) {
            System.out.println("COLLISION PASCALLLLLLLLLLLLLLLLLLLLLLLLL");
            return true;   // I entre A et B, ok.
        }


        if(collisionPointCercle(wall.getBeginning(), ball)) {
            System.out.println("COLLISION AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            return true;
        }

        if(collisionPointCercle(wall.getEnding(), ball)) {
            System.out.println("COLLISION BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
            return true;
        }

        return false;
    }

    public static Vecteur projectionI(AbstractBall ball, Wall wall) {
        Vecteur u, AC;
        u = new Vecteur(wall.getEnding().x - wall.getBeginning().x, wall.getEnding().y - wall.getBeginning().y);
        AC = new Vecteur(ball.getPosition().x - wall.getBeginning().x, ball.getPosition().y - wall.getBeginning().y);
        double ti = (u.x*AC.x + u.y*AC.y)/(u.x*u.x + u.y*u.y);
        Vecteur I;
        I = new Vecteur(wall.getBeginning().x + ti*u.x, wall.getBeginning().y + ti*u.y);
        return I;
    }

    public static Vecteur getNormale(AbstractBall ball, Wall wall) {
        Vecteur AC, u, N;
        u = new Vecteur(wall.getEnding().x - wall.getBeginning().x, wall.getEnding().y - wall.getBeginning().y);
        AC = new Vecteur(ball.getPosition().x - wall.getBeginning().x, ball.getPosition().y - wall.getBeginning().y);
        double parenthesis = u.x*AC.x-u.y*AC.y;
        N = new Vecteur(-u.y*(parenthesis), u.x*(parenthesis));
        double norme = Math.sqrt(N.x * N.x + N.y * N.y);
        N.x /= norme;
        N.y /= norme;
        return N;
    }

    public static Vecteur calculerVecteurV2(Vecteur v, Vecteur N) {
        Vecteur v2;
        double pscal = (v.x*N.x + v.y*N.y);
        v2 = new Vecteur(v.x-2*pscal*N.x, v.y-2*pscal*N.y);

        return v2;
    }

    public static boolean collisionDroite(AbstractBall ball, Wall wall) {
        Vecteur u = new Vecteur(wall.getEnding().x - wall.getBeginning().x, wall.getEnding().y - wall.getBeginning().y);
        Vecteur AC = new Vecteur(ball.getPosition().x - wall.getBeginning().x, ball.getPosition().y - wall.getBeginning().y);
        double numerateur = u.x * AC.y - u.y * AC.x;
        if(numerateur < 0) {
            numerateur = -numerateur;
        }
        double denominateur = Math.sqrt(u.x * u.x + u.y * u.y);
        double CI = numerateur/denominateur;
        if(CI < ball.getRadius()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean collisionPointCercle(Vecteur point, AbstractBall ball) {
        return distCarre(point, ball.getPosition()) < ball.getRadius() * ball.getRadius();
    }


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
