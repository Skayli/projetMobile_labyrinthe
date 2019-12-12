package com.mygdx.game.view.texture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.model.Cannon;

public class TextureCannon  {

    private Cannon cannon;
    private Texture texture;

    public TextureCannon(Cannon cannon)
    {
        this.cannon = cannon;
        texture = new Texture(Gdx.files.internal("cannon.png"));
    }
}
