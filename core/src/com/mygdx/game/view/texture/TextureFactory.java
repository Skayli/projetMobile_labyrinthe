package com.mygdx.game.view.texture;

import com.mygdx.game.model.Cannon;
import com.mygdx.game.model.GameWorld;

import java.util.HashMap;

public class TextureFactory {

    private static TextureFactory instance = null;

    private HashMap<Class<?>, ITexturable> textures;
    private static GameWorld gameWorld;

    private TextureFactory()
    {
        textures = new HashMap<Class<?>, ITexturable>();
//        textures.put(Cannon.class, new TextureCannon());
    }
}
