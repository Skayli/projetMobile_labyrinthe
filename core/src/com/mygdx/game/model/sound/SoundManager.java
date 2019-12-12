package com.mygdx.game.model.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.model.GameWorld;

public class SoundManager {

    private static SoundManager instance;
    public static Music bg;
    public static Music victory;
    public static Sound hit;
    public static Sound death;

    private SoundManager() {

    }

    public static SoundManager getInstance() {
        if(instance == null) {
            instance = new SoundManager();

            bg = Gdx.audio.newMusic(Gdx.files.internal("bg.mp3"));
            bg.setLooping(true);

            victory = Gdx.audio.newMusic(Gdx.files.internal("victory.mp3"));

            hit  = Gdx.audio.newSound(Gdx.files.internal("bille_bille.wav"));

            death = Gdx.audio.newSound(Gdx.files.internal("death.wav"));
        }

        return instance;
    }

    public void play(Music music) {
        music.play();
    }

    public void play(Sound sound, float volume) {
        sound.play(volume);
    }

    public void stop(Music music) {
        music.stop();
    }



}
