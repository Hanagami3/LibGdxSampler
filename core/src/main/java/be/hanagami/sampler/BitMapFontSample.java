package be.hanagami.sampler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


import be.hanagami.sampler.common.SampleBase;
import be.hanagami.sampler.common.SampleInfo;

public class BitMapFontSample extends SampleBase {

    public static final SampleInfo SAMPLE_INFO = new SampleInfo(BitMapFontSample.class);

    private static final float WIDTH = 1080f;
    private static final float HEIGHT = 720f;

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont effectFont;
    private BitmapFont uiFont;
    private GlyphLayout glyphLayout = new GlyphLayout();

    @Override
    public void create() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(WIDTH, HEIGHT, camera);
        batch = new SpriteBatch();
        effectFont = new BitmapFont(Gdx.files.internal("fonts/effect_font_32.fnt"));
        uiFont = new BitmapFont(Gdx.files.internal("fonts/ui_font_32.fnt"));
        uiFont.getData().markupEnabled = true;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();
    }

    private void draw(){
        String text1 = "Using Bitmap Font";

//        effectFont.draw(batch, text1, 20, HEIGHT);
        effectFont.draw(batch, text1, 20, HEIGHT, 50, 0, true);

        String text2 = "[#FF0000]BITMAP [GREEN]FONT [YELLOW]ARE [BLUE]COOL!";
        glyphLayout.setText(uiFont, text2);
        uiFont.draw(
            batch,
            text2,
            (WIDTH - glyphLayout.width) / 2f,
            (HEIGHT - glyphLayout.height) / 2f
        );

    }

    @Override
    public void dispose() {
        batch.dispose();
        effectFont.dispose();
        uiFont.dispose();
    }
}
