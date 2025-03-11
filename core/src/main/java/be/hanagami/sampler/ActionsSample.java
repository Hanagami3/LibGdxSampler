package be.hanagami.sampler;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import be.hanagami.sampler.common.CustomActor;
import be.hanagami.sampler.common.SampleBase;
import be.hanagami.sampler.common.SampleInfo;
import be.hanagami.sampler.utils.GdxUtils;

public class ActionsSample extends SampleBase {

    private static final Logger log = new Logger (CustomActorSample.class.getName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(CustomActorSample.class);

    private static final float WORLD_WIDTH = 1080f;
    private static final float WORLD_HEIGHT = 720f;

    //private OrthographicCamera camera;
    private Viewport viewport;
    ///private SpriteBatch batch;

    private Stage stage;
    private Texture texture;
    private CustomActor customActor;


    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        //camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        stage = new Stage(viewport);

        texture = new Texture(Gdx.files.internal("raw/custom-actor.png"));

        customActor = new CustomActor(new TextureRegion(texture));
        customActor.setSize(160, 80);
        customActor.setPosition(
            (WORLD_WIDTH - customActor.getWidth()) / 2f,
            (WORLD_HEIGHT - customActor.getHeight()) / 2f
        );

        stage.addActor(customActor);
        Gdx.input.setInputProcessor(this);

        String LS = System.getProperty("line.separator");
        String TAB = "\t";

        log.debug(LS + "Press keys." + LS +
            TAB + "1 - RotateBy Action" + LS +
            TAB + "2 - FadeOut Action" + LS +
            TAB + "3 - FadeIn Action" + LS +
            TAB + "4 - ScaleTo Action" + LS +
            TAB + "5 - MoveTo Action" + LS +
            TAB + "6 - Sequential Action" + LS +
            TAB + "7 - Parallel Action"
            );

    }

    @Override
    public boolean keyDown(int keycode) {
        customActor.clearActions();

        if (keycode == Input.Keys.NUM_1){
            log.debug("RotateBy Action");
            customActor.addAction(rotateBy(90f, 1f));
        } else if (keycode == Input.Keys.NUM_2) {
            customActor.addAction(fadeOut(2f));
        } else if (keycode == Input.Keys.NUM_3) {
            log.debug("FadeIn Action");
            customActor.addAction(fadeIn(2f));
        }else if (keycode == Input.Keys.NUM_4) {
            log.debug("ScaleTo Action");
            customActor.addAction(scaleTo(1.5f, 1.5f, 2f));
        }else if (keycode == Input.Keys.NUM_5) {
            log.debug("MoveTo Action");
            customActor.addAction(moveTo(100, 100, 3f));
        }else if (keycode == Input.Keys.NUM_6) {
            log.debug("Sequential Action");
            customActor.addAction(sequence(
                fadeOut(1f),
                fadeIn(0.5f)
            ));
        }else if (keycode == Input.Keys.NUM_7) {
            log.debug("Parallel Action");
            customActor.addAction(parallel(
                rotateBy(90, 2f),
                moveBy(50, 50, 2f)
            ));
        }

        return true;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        texture.dispose();
    }
}
