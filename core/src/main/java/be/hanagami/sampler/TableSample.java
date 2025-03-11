package be.hanagami.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import be.hanagami.sampler.common.CustomActor;
import be.hanagami.sampler.common.SampleBase;
import be.hanagami.sampler.common.SampleInfo;
import be.hanagami.sampler.utils.GdxUtils;

public class TableSample extends SampleBase {

    private static final Logger log = new Logger (TableSample.class.getName(), Logger.DEBUG);

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(TableSample.class);

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

        initUi();

    }

    private void initUi() {
        Table table = new Table();
        table.defaults().space(20);

        for (int i = 0; i < 6; i++){
            CustomActor customActor = new CustomActor(new TextureRegion(texture));

            customActor.setSize(180, 60);
            table.add(customActor);
            table.row();
        }

        table.row();
        CustomActor actor = new CustomActor(new TextureRegion(texture));
        actor.setSize(200, 40);
//        table.add(actor).expandX();
        table.add(actor).fillX().expandX().left();
        table.row();

        table.center();
        table.setFillParent(true);
        table.pack();

        stage.addActor(table);
        stage.setDebugAll(true);
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
