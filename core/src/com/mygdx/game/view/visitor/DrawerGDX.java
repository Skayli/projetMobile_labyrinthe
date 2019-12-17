package com.mygdx.game.view.visitor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.model.Cannon;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.Hole;
import com.mygdx.game.model.Target;
import com.mygdx.game.model.Wall;
import com.mygdx.game.view.VisitorWorld;
import com.mygdx.game.view.texture.TextureCannon;

import mesmaths.geometrie.base.Vecteur;

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
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));


        batch.setProjectionMatrix(camera.combined);
        shape.setProjectionMatrix(camera.combined);

        batch.begin();

        Gdx.gl20.glLineWidth(5);

        //Dessin de la cible
        com.mygdx.game.model.color.Color colorTarget = game.getCurrentLevel().getTarget().getColor();
        Color colorTargetGDX = new Color(colorTarget.getRed(), colorTarget.getGreen(), colorTarget.getBlue(), 1);
        Target target = game.getCurrentLevel().getTarget();
        shape.setColor(colorTargetGDX);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.rect((float) target.getBottomLeft().x, (float) target.getBottomLeft().y, (float) target.getWidth(), (float) target.getHeight());
        shape.end();

        // Dessin des composants qui décorent le niveau courant
        game.getCurrentLevel().getLevelComponent().draw(this);

        //Dessin de la bille contrôlée par le joueur
        com.mygdx.game.model.color.Color billeColor = game.getBall().getColor();

        Color ballColor = new Color(billeColor.getRed(), billeColor.getGreen(), billeColor.getBlue(), 1);
        Vecteur positionBille = game.getBall().getPosition();

        shape.setColor(ballColor);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle((float) positionBille.x, (float) positionBille.y, (float) game.getBall().getRadius());
        shape.end();

        //Dessin du contour de la bille
        shape.setColor(Color.BLACK);
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.circle((float) positionBille.x, (float) positionBille.y, (float) game.getBall().getRadius());
        shape.end();

        batch.end();
    }

    public void draw(Wall wall)
    {
        shape.setColor(Color.BLACK);
        shape.begin(ShapeRenderer.ShapeType.Line);
        shape.line((float) wall.getBeginning().x, (float) wall.getBeginning().y, (float) wall.getEnding().x, (float) wall.getEnding().y);
        shape.end();
    }

    public void draw(Hole hole)
    {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.circle((float) hole.getPosition().x, (float) hole.getPosition().y, hole.getRadius());
        shape.end();
    }

    public void draw(Cannon cannon)
    {
        Texture textureCannon = new Texture(Gdx.files.internal("cannon.png"));
        Sprite spriteCannon = new Sprite(textureCannon);
//        batch.draw(spriteCannon, 50, 50, 100, 100);
    }

    // ------------------------------------- \\
    // --- Fin de la classe VisitorWorld --- \\
    // ------------------------------------- \\
}
