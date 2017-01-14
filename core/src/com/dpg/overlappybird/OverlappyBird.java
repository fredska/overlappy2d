package com.dpg.overlappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

public class OverlappyBird extends ApplicationAdapter {
	/*
    * GameStage will be holding both menu and main game
    */
	private GameStage stage;

	private SceneLoader sl;
	private Viewport viewport;

	private ItemWrapper rootItem;

	@Override
	public void create () {

		viewport = new FitViewport(480,800);
		sl = new SceneLoader();
		sl.loadScene("MenuScene", viewport);

		rootItem = new ItemWrapper(sl.getRoot());

		// all entities with button tag now have ButtonComponent
		sl.addComponentsByTagName("button", ButtonComponent.class);

		// retrieve particular button, and it's component, and add listener to it.
		ButtonComponent buttonComponent = rootItem.getChild("playBtn").getEntity().getComponent(ButtonComponent.class);
		buttonComponent.addListener(new ButtonComponent.ButtonListener() {
			public void touchUp() {

			}
			public void touchDown() {

			}
			public void clicked() {
				System.out.println("Play Button Clicked");
			}
		});

		stage = new GameStage(sl);
	}

	@Override
	public void render () {
		act();

		Gdx.gl.glClearColor(36/225f, 20/225f, 116/225f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sl.getEngine().update(Gdx.graphics.getDeltaTime()); // getting the ashley engine and updating it (it will render things with it's own render system)

		stage.act();
		stage.draw();
	}

	public void act() {
		OrthographicCamera camera = (OrthographicCamera)viewport.getCamera();
//		camera.position.x = 0;

		if(camera.position.x < viewport.getWorldWidth()/2) camera.position.x = viewport.getWorldWidth()/2;

	}
}