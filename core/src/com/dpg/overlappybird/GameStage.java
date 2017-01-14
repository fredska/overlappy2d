package com.dpg.overlappybird;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.components.additional.ButtonComponent;
import com.uwsoft.editor.renderer.data.CompositeItemVO;
import com.uwsoft.editor.renderer.resources.ResourceManager;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

/**
 * Created by Fred on 1/11/2017.
 */
public class GameStage extends Stage{
    // Speed of pixels per second of how fast things move left (required both for
    // menu and the game,
    // thus put here)

    public float gameSpeed = 200;

    // Overlap2D  provides this easy asset manager that loads things as they are
    // provided by default when exporting from overlap
    private ResourceManager assetManager;

    private Viewport viewPort;

    private SceneLoader sl;
    private ItemWrapper rootItem;

    public GameStage(SceneLoader sl){
        super(new StretchViewport(480,800));
        Gdx.input.setInputProcessor(this);
        this.sl = sl;



        //assetManager = new ResourceManager();
//        assetManager.initAllResources();

        initMenu();
    }

    public void initMenu() {
        clear();

        CompositeItemVO ciVO = sl.loadVoFromLibrary("playBtnLib");
        CompositeActor button = new CompositeActor(ciVO, sl.getRm());
//        button.setX(getWidth()-button.getWidth());
//        button.setY(getHeight()-button.getHeight());
        button.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                System.out.println("Button Clicked");
            }
        });
//        addActor(button);

    }

//    public void initGame() {
//        clear();
//
//        // Creating Scene loader which can load an Overlap2D scene
//        SceneLoader mainLoader = new SceneLoader(assetManager);
//
//        // loading MainScene.dt from assets folder
//        mainLoader.loadScene(Gdx.files.internal("FlappyBird/assets/overlap2d_project/scenes/scenes/MainScene.dt").pathWithoutExtension());
//
//        // Initializing iScript GameSceneScript that will be holding all game, and
//        // passing this stage for later use
//        GameScreenScript gameScript = new GameScreenScript(this, mainLoader);
//
//        // adding this script to the root scene of game which is hold in
//        // mainLoader.sceneActor
//        mainLoader.sceneActor.addScript(gameScript);
//
//        // Adding root actor to stage
//        addActor(mainLoader.sceneActor);
//    }

}