package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.controller.Controller;
import com.mygdx.game.model.GameWorld;
import com.mygdx.game.model.sound.SoundManager;
import com.mygdx.game.view.GameView;
import com.mygdx.game.view.visitor.DrawerGDX;

/**
 * Classe d'entrée du jeu
 */
public class LabyrintheGame extends ApplicationAdapter {

	//Model
	GameWorld game;

	//View
	GameView view;

	//Controller
	Controller controller;


	@Override
	public void create () {
		// Création des composants
		this.game = new GameWorld();
		this.view = new GameView(new DrawerGDX());
		this.controller = new Controller();

		// Ajout des controleurs
		game.addObserver(controller.getObsModel());
		controller.addObserver(view);
	}

	@Override
	public void render () {
		game.update();
	}
	
	@Override
	public void dispose () {

	}
}
