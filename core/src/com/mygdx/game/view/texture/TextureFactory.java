package com.mygdx.game.view.texture;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.model.Cannon;
import com.mygdx.game.model.GameWorld;

import java.util.HashMap;

public class TextureFactory {

    private static TextureFactory instance = null;

    private HashMap<Class<?>, ITexturable> textures;

    private TextureFactory()
    {
        textures = new HashMap<Class<?>, ITexturable>();
        textures.put(Cannon.class, new TextureCannon());
    }

    public static TextureFactory getInstance() {
        if(instance == null) {
            instance = new TextureFactory();
        }

        return instance;
    }

    public Texture getTexture(Class<?> c) {
        return textures.get(c).getTexture();
    }

    public Sprite getSprite(Class<?> c) {
        return  textures.get(c).getSprite();
    }

}
