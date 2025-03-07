package be.hanagami.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.ScreenUtils;

import be.hanagami.sampler.common.SampleBase;
import be.hanagami.sampler.common.SampleInfo;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class ApplicationListenerSample extends SampleBase {

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(ApplicationListenerSample.class);
    private static final Logger log = new Logger(ApplicationListenerSample.class.getName(), Logger.DEBUG);

    private boolean renderInterrupted = true;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        log.debug("create()");
    }

    @Override
    public void resize(int width, int height) {
        log.debug("resize() width= " + width + " height = " + height );
    }

    @Override
    public void render() {
        if (renderInterrupted) {
            log.debug("render()");
            renderInterrupted = false;
        }
    }

    @Override
    public void pause() {
        log.debug("pause()");
        renderInterrupted = false;
    }

    @Override
    public void resume() {
        log.debug("resume()");
        renderInterrupted = true;

    }

    @Override
    public void dispose() {
        log.debug("dispose()");
    }
}
