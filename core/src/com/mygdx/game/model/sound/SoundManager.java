package com.mygdx.game.model.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {

    private static SoundManager instance;
    private static Music bg;
    private static Sound hit;

    private SoundManager() {

    }

    public static SoundManager getInstance() {
        if(instance == null) {
            instance = new SoundManager();
            bg = Gdx.audio.newMusic(Gdx.files.internal("bg.mp3"));
            bg.setLooping(true);

            hit  = Gdx.audio.newSound(Gdx.files.internal("bille_bille.wav"));
        }

        return instance;
    }

    public void playBackground() {
        bg.play();
    }

    public void playCollision(float intensite) {
        hit.play(intensite);
    }

}
