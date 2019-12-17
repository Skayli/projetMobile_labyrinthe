package com.mygdx.game.view.texture;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TextureCannon implements ITexturable {

    private Texture texture;
    private Sprite sprite;

    public TextureCannon()
    {
        texture = new Texture("cannon.png");
        sprite = new Sprite(texture);
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }
}
