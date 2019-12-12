package com.mygdx.game.model.sound;

import com.badlogic.gdx.audio.Music;
import com.mygdx.game.model.GameWorld;

public class ListenerVictoryCompletion implements Music.OnCompletionListener {

    GameWorld game;

    public ListenerVictoryCompletion(GameWorld game) {
        this.game = game;
    }

    @Override
    public void onCompletion(Music music) {
        game.goToNextLevel();
        game.getBall().setCurrentGameBallState(game.getBall().getGameBallStateAlive());
        SoundManager.getInstance().play(SoundManager.bg);
    }
}
