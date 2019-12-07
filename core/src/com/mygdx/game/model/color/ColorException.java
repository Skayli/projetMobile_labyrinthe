package com.mygdx.game.model.color;

/**
 * Classe d'exception pour les couleurs
 */
public class ColorException extends Exception {

    private final String CLASSIC_MESSAGE = "Incorrect color value. Expecting value between 0 and 255.";

    public ColorException() { }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println(CLASSIC_MESSAGE);
    }
}
