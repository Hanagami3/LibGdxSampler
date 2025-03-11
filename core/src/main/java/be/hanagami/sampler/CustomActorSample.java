package be.hanagami.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import be.hanagami.sampler.common.CustomActor;
import be.hanagami.sampler.common.SampleBase;
import be.hanagami.sampler.common.SampleInfo;
import be.hanagami.sampler.utils.GdxUtils;

public class CustomActorSample extends SampleBase {

    private static final Logger log = new Logger (CustomActorSample.class.getName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(CustomActorSample.class);

    private static final float WORLD_WIDTH = 1080f;
    private static final float WORLD_HEIGHT = 720f;

    //private OrthographicCamera camera;
    private Viewport viewport;
    ///private SpriteBatch batch;

    private Stage stage;
    private Texture texture;


    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        //camera = new OrthographicCamera();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        stage = new Stage(viewport);

        texture = new Texture(Gdx.files.internal("raw/custom-actor.png"));

        CustomActor customActor = new CustomActor(new TextureRegion(texture));
        customActor.setSize(160, 80);
        customActor.setPosition(
            (WORLD_WIDTH - customActor.getWidth()) / 2f,
            (WORLD_HEIGHT - customActor.getHeight()) / 2f
        );

        customActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                log.debug("customActor clicked event= " + event + "x= " + " y= " + y);
            }
        });

        stage.addActor(customActor);
        Gdx.input.setInputProcessor(stage);

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
