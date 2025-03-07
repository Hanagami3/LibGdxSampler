package be.hanagami.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import be.hanagami.sampler.common.SampleBase;
import be.hanagami.sampler.common.SampleInfo;
import be.hanagami.sampler.utils.GdxUtils;

/**
 * {@link ApplicationListener} implementation shared by all platforms.
 */
public class InputListeningSample extends SampleBase implements InputProcessor {

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(InputListeningSample.class);
    private static final Logger log = new Logger (InputListeningSample.class.getName(), Logger.DEBUG);
    private static final int MAX_MESSAGE_COUNT = 15;

    private final Array<String> messages = new Array<>();

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);


        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));

        Gdx.input.setInputProcessor(this);
//        InputMultiplexer multiplexer = new InputMultiplexer();
//
//        InputAdapter firstProcessor = new InputAdapter(){
//            @Override
//            public boolean keyDown(int keycode) {
//                log.debug("first - keyDown keycode= " + keycode);
//                return true;
//            }
//
//            @Override
//            public boolean keyUp(int keycode) {
//                log.debug("first - keyUp keycode= " + keycode);
//                return false;
//            }
//
//            @Override
//            public boolean keyTyped(char character) {
//                log.debug("first - keyTyped keycode= " + character);
//                return false;
//            }
//        };
//        InputAdapter secondProcessor = new InputAdapter(){
//            @Override
//            public boolean keyDown(int keycode) {
//                log.debug("second - keyDown character= " + keycode);
//                return true;
//            }
//
//            @Override
//            public boolean keyUp(int keycode) {
//                log.debug("second - keyUp keycode= " + keycode);
//                return false;
//            }
//
//            @Override
//            public boolean keyTyped(char character) {
//                log.debug("second - keyTyped keycode= " + character);
//                return false;
//            }
//        };
//
//        multiplexer.addProcessor(firstProcessor);
//        multiplexer.addProcessor(secondProcessor);
//
//        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    private void draw() {
        for (int i = 0; i < messages.size; i++) {
            font.draw(
                batch,
                messages.get(i),
                20.0f,
                720 - 40.0f * (i + 1)
            );
        }
    }

    private void addMessage(String message) {
        messages.add(message);

        if (messages.size > MAX_MESSAGE_COUNT) {
            messages.removeIndex(0);
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }


    @Override
    public boolean keyDown(int keycode) {
        String message = "KeyDown keycode= " + keycode;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        String message = "KeyUp keycode= " + keycode;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        String message = "KeyTyped keycode= " + character;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        String message = "touchDown screenX= " + screenX + "screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        String message = "touchUp screenX= " + screenX + "screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        String message = "touchCancelled screenX= " + screenX + "screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        String message = "touchDragged screenX= " + screenX + "screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        String message = "mouseMoved screenX= " + screenX + "screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        String message = "scrolled amountX= " + amountX + "amountY= " + amountY;
        log.debug(message);
        addMessage(message);
        return true;
    }
}
