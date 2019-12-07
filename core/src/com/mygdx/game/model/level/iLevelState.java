package com.mygdx.game.model.level;

/**
 * Interface servant à gérer les états des levels dans GameWorld
 */
public interface iLevelState {
    public AbstractLevel getNextLevel();
}
