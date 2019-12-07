package com.mygdx.game.controller;

import com.mygdx.game.model.GameWorld;
import java.util.Observable;

/**
 * Classe représentant le controleur dans le pattern MVC
 */
public class Controller extends Observable {

    private ObserverModel obsModel;
    private ObserverView obsView;

    public Controller() {
        this.obsModel = new ObserverModel(this);
        this.obsView = new ObserverView(this);
    }

    // ------------------------ \\
    // --- Fonctions update --- \\
    // ------------------------ \\

    public void updateModel(GameWorld game) {
        this.setChanged();
        this.notifyObservers(game);
    }

    public void updateView(GameWorld game) {
        this.setChanged();
        this.notifyObservers(game);
    }

    // --------------- \\
    // --- Getters --- \\
    // --------------- \\

    public ObserverModel getObsModel() {
        return this.obsModel;
    }

    public ObserverView getObsView() {
        return this.obsView;
    }

    // ----------------------------------- \\
    // --- Fin de la classe Controller --- \\
    // ----------------------------------- \\
}
