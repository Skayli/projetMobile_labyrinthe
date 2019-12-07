package com.mygdx.game.view.visitor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.view.VisitorWorld;

/**
 * Classe de dessin utilisant GDX
 */
public class DrawerGDX extends VisitorWorld {

    OrthographicCamera camera;
    SpriteBatch batch;
    ShapeRenderer shape;

    public DrawerGDX() {
        camera = new OrthographicCamera(GameWorld.WIDTH, GameWorld.HEIGHT);
        camera.position.set(GameWorld.WIDTH/2, GameWorld.HEIGHT/2,0);
        camera.update();

        batch = new SpriteBatch();
        shape = new ShapeRenderer();
    }


    @Override
    public void draw(GameWorld game) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        shape.setProjectionMatrix(camera.combined);

        batch.begin();

        // EXemple de comment dessiner des formes
        shape.setColor(Color.CORAL);
        shape.begin(ShapeRenderer.ShapeType.Line);
        Gdx.gl20.glLineWidth(10);
        shape.line(GameWorld.WIDTH/3, GameWorld.HEIGHT/3,2*GameWorld.WIDTH/3, 2*GameWorld.HEIGHT/3);
        shape.end();

        shape.setColor(Color.GREEN);
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.curve(0,GameWorld.HEIGHT,0,0,GameWorld.WIDTH,0,GameWorld.WIDTH,GameWorld.HEIGHT,100);
        shape.end();

        shape.setColor(Color.BLUE);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.ellipse(0,0,1000,1000);
        shape.end();



        batch.end();
    }

    // ------------------------------------- \\
    // --- Fin de la classe VisitorWorld --- \\
    // ------------------------------------- \\
}
