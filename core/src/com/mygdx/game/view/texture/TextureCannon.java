package com.mygdx.game.view.texture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.model.Cannon;

public class TextureCannon implements ITexturable {

    private Texture texture;

    public TextureCannon()
    {
        texture = new Texture("cannon.png");
    }

    @Override
    public Texture getTexture() {
        return texture;
    }
}
