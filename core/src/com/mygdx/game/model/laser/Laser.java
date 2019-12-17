package com.mygdx.game.model.laser;

import com.badlogic.gdx.Game;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.color.Color;
import com.mygdx.game.model.laser.LaserStates.LaserState;
import com.mygdx.game.model.laser.LaserStates.LaserStateAlive;
import com.mygdx.game.model.laser.LaserStates.LaserStateDead;

import mesmaths.geometrie.base.Vecteur;

public class Laser {
    private GameWorld game;

    private Vecteur beginning;
    private Vecteur ending;
    private Color color;

    private int timeAlive;
    private int timeDead;
    private int seuil;

    private LaserState currentState, stateAlive, stateDead;

    public Laser(GameWorld game, double xBeginning, double yBeginning, double xEnding, double yEnding, int timeAlive, int timeDead, int currentSeuil, boolean isAlive) {
        this.game = game;
        this.beginning = new Vecteur(xBeginning, yBeginning);
        this.ending = new Vecteur(xEnding, yEnding);
        this.color = Color.RED();
        this.timeAlive = timeAlive;
        this.timeDead = timeDead;
        this.seuil = currentSeuil;

        stateAlive = new LaserStateAlive(this);
        stateDead = new LaserStateDead(this);

        currentState = (isAlive ? stateAlive : stateDead);
    }

    //Fonctions
    public void update() {
        seuil++;
        this.currentState.update();
    }

    //Getters & setters


    public Vecteur getBeginning() {
        return beginning;
    }

    public void setBeginning(Vecteur beginning) {
        this.beginning = beginning;
    }

    public Vecteur getEnding() {
        return ending;
    }

    public void setEnding(Vecteur ending) {
        this.ending = ending;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTimeAlive() {
        return timeAlive;
    }

    public void setTimeAlive(int timeAlive) {
        this.timeAlive = timeAlive;
    }

    public int getTimeDead() {
        return timeDead;
    }

    public void setTimeDead(int timeDead) {
        this.timeDead = timeDead;
    }

    public int getSeuil() {
        return seuil;
    }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }

    public LaserState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(LaserState currentState) {
        this.currentState = currentState;
    }

    public LaserState getStateAlive() {
        return stateAlive;
    }

    public void setStateAlive(LaserState stateAlive) {
        this.stateAlive = stateAlive;
    }

    public LaserState getStateDead() {
        return stateDead;
    }

    public void setStateDead(LaserState stateDead) {
        this.stateDead = stateDead;
    }

    public boolean isAlive() {
        return this.currentState == this.stateAlive;
    }

    public GameWorld getGame() {
        return game;
    }

    public void setGame(GameWorld game) {
        this.game = game;
    }
}
