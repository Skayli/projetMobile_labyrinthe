package com.mygdx.game.model.color;

/**
 * Classe représentant une couleur au format RGB
 */
public class Color {

    private int red, green, blue;

    public Color(int red, int green, int blue) {
        try  {
            if(!isColorValid(red, green, blue)) {
                throw new ColorException();
            } else {
                this.red = red;
                this.green = green;
                this.blue = blue;
            }
        } catch (ColorException e) {
            e.printStackTrace();
        }

    }

    // Vérifie si une couleur est valide (rgb entre 0 et 255)
    private boolean isColorValid(int red, int green, int blue) {
        return isValueValid(red) && isValueValid(green) && isValueValid(blue);
    }

    // Vérifie si une valeur est valide
    private boolean isValueValid(int colorValue) {
        return colorValue > -1 && colorValue < 256;
    }

    // ------------------------- \\
    // --- Getters & setters --- \\\
    // ------------------------- \\

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }


    // ---------------------------- \\
    // --- Couleurs prédéfinies --- \\
    // ---------------------------- \\

    /**
     * Couleur rouge
     * @return
     */
    public static Color RED() {
        return new Color(255,0,0);
    }

    /**
     * Couleur verte
     * @return
     */
    public static Color GREEN() {
        return new Color(0,255,0);
    }

    /**
     * Couleur bleue
     * @return
     */
    public static Color BLUE() {
        return new Color(0,0,255);
    }

    /**
     * Couleur noire
     * @return
     */
    public static Color BLACK() { return new Color(0,0,0); }

    // ----------------------------- \\
    // --- Fin de la class Color --- \\
    // ----------------------------- \\
}
