package com.mygdx.game.model;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.ball.AbstractBall;
import com.mygdx.game.model.ball.GameBall;
import com.mygdx.game.model.sound.SoundManager;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import mesmaths.geometrie.base.Matrice;
import mesmaths.geometrie.base.Vecteur;

public class MaCollision {

    public static boolean collisionBilleSegment(AbstractBall ball, Wall wall) {
        if(collisionSegment(ball.getPosition(), ball.getRadius(), wall.getBeginning(), wall.getEnding())) {
            Vecteur projection = projectionI(ball, wall);
            Vecteur dir = new Vecteur(ball.getPosition().x - projection.x, ball.getPosition().y - projection.y);
            double vN = ball.getVelocity().produitScalaire(dir);

            if(vN < 0) {
                //Calcul rebond
                Vecteur normale = getNormale(ball, wall);
                double pscal = (ball.getVelocity().x*normale.x + ball.getVelocity().y*normale.y);
                Vecteur rebond = new Vecteur(ball.getVelocity().x-2*pscal*normale.x, ball.getVelocity().y-2*pscal*normale.y);
                ball.setVelocity(rebond);

                boolean playSound = true;


                //Ressort du mur pou éviter que la bille ne s'enfonce trop
                double k = 0.25;
                double epsilone = 2;
                if(vN > -3085) {
                    double normeDir = dir.norme();
                    dir.multiplie(1/normeDir);
                    dir.multiplie(k);
                    dir.multiplie(epsilone);
                    ball.getVelocity().ajoute(dir);
                    playSound = false;
                }

                //jouer son proportionnel au rebond
                if(playSound == true)
                    SoundManager.getInstance().play(SoundManager.hit, (float) Math.abs(pscal) / 100);

                return true;
            }
        }

        return false;
    }

    public static boolean collisionSegment(Vecteur position, double radius, Vecteur beginning, Vecteur ending) {
        if(!collisionDroite(position, radius, beginning, ending)) {
            return false;
        }

        Vecteur AB, AC, BC;
        AB = new Vecteur(ending.x - beginning.x, ending.y - beginning.y);
        AC = new Vecteur(position.x - beginning.x, position.y - beginning.y);
        BC = new Vecteur(position.x - ending.x, position.y - ending.y);

        double pscal1 = AB.x*AC.x + AB.y*AC.y;  // produit scalaire
        double pscal2 = (-AB.x)*BC.x + (-AB.y)*BC.y;  // produit scalaire
        if (pscal1>=0 && pscal2>=0) {
            return true;   // I entre A et B, ok.
        }


        if(collisionPointCercle(beginning, position, radius)) {
            return true;
        }

        if(collisionPointCercle(ending, position, radius)) {
            return true;
        }

        return false;
    }

    public static boolean collisionHole(AbstractBall ball, Hole hole)
    {
        double dist = Math.sqrt(MaCollision.distCarre(hole.getPosition(), ball.getPosition()));
        if ( (dist + (ball.getRadius()*0.30)) < (hole.getRadius()))
        {
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

        SoundManager.getInstance().play(SoundManager.hit, (float) Math.abs(pscal)/100);

        v2 = new Vecteur(v.x-2*pscal*N.x, v.y-2*pscal*N.y);

        return v2;
    }

    public static boolean collisionDroite(Vecteur position, double radius, Vecteur beginning, Vecteur ending) {
        Vecteur u = new Vecteur(ending.x - beginning.x, ending.y - beginning.y);
        Vecteur AC = new Vecteur(position.x - beginning.x, position.y - beginning.y);
        double numerateur = u.x * AC.y - u.y * AC.x;
        if(numerateur < 0) {
            numerateur = -numerateur;
        }
        double denominateur = Math.sqrt(u.x * u.x + u.y * u.y);
        double CI = numerateur/denominateur;
        if(CI < radius) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean collisionPointCercle(Vecteur point, Vecteur position, double radius) {
        return distCarre(point, position) < radius*radius;
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

    /**
     * Vérifie si un point se trouve à l'intérieur d'un rectangle
     * @param point
     * @param rectBottomLeftPoint
     * @param rectWidth
     * @param rectHeight
     * @return
     */
    public static boolean isPointInRectangle(Vecteur point, Vecteur rectBottomLeftPoint, double rectWidth, double rectHeight) {
        boolean inX = point.x > rectBottomLeftPoint.x && point.x < rectBottomLeftPoint.x + rectWidth;
        boolean inY = point.y > rectBottomLeftPoint.y && point.y < rectBottomLeftPoint.y + rectHeight;

        return inX && inY;
    }

    /**
     * Vérifie si un cercle est entièrement à l'intérieur d'un rectangle
     * @param circleCenter
     * @param circleRadius
     * @param rectBottomLeftPoint
     * @param rectWidth
     * @param rectHeight
     * @return
     */
    public static boolean isCircleInRectangle(Vecteur circleCenter, double circleRadius, Vecteur rectBottomLeftPoint, double rectWidth, double rectHeight) {
        boolean inX = circleCenter.x - circleRadius > rectBottomLeftPoint.x && circleCenter.x + circleRadius < rectBottomLeftPoint.x + rectWidth;
        boolean inY = circleCenter.y - circleRadius > rectBottomLeftPoint.y && circleCenter.y + circleRadius < rectBottomLeftPoint.y + rectHeight;

        return inX && inY;
    }
}
