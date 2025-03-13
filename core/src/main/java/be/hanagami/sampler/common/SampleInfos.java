package be.hanagami.sampler.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import be.hanagami.sampler.ActionsSample;
import be.hanagami.sampler.ApplicationListenerSample;
import be.hanagami.sampler.AshleyEngineSample;
import be.hanagami.sampler.AssetManagerSample;
import be.hanagami.sampler.BitMapFontSample;
import be.hanagami.sampler.CustomActorSample;
import be.hanagami.sampler.GdxGeneratedSample;
import be.hanagami.sampler.GdxModuleInfoSample;
import be.hanagami.sampler.GdxReflectionSample;
import be.hanagami.sampler.InputListeningSample;
import be.hanagami.sampler.InputPollingSample;
import be.hanagami.sampler.OrthographicCameraSample;
import be.hanagami.sampler.PoolingSample;
import be.hanagami.sampler.ShapeRendererSample;
import be.hanagami.sampler.SkinSample;
import be.hanagami.sampler.SpriteBatchSample;
import be.hanagami.sampler.TableSample;
import be.hanagami.sampler.TextureAtlasSample;
import be.hanagami.sampler.ViewportSample;

/**
 * Created by goran on 20/08/2016.
 */
public class SampleInfos {

    public static final List<SampleInfo> ALL = Arrays.asList(
        ApplicationListenerSample.SAMPLE_INFO,
        GdxGeneratedSample.SAMPLE_INFO,
        GdxModuleInfoSample.SAMPLE_INFO,
        GdxReflectionSample.SAMPLE_INFO,
        InputListeningSample.SAMPLE_INFO,
        InputPollingSample.SAMPLE_INFO,
        OrthographicCameraSample.SAMPLE_INFO,
        ViewportSample.SAMPLE_INFO,
        SpriteBatchSample.SAMPLE_INFO,
        ShapeRendererSample.SAMPLE_INFO,
        BitMapFontSample.SAMPLE_INFO,
        PoolingSample.SAMPLE_INFO,
        AssetManagerSample.SAMPLE_INFO,
        TextureAtlasSample.SAMPLE_INFO,
        CustomActorSample.SAMPLE_INFO,
        ActionsSample.SAMPLE_INFO,
        TableSample.SAMPLE_INFO,
        SkinSample.SAMPLE_INFO,
        AshleyEngineSample.SAMPLE_INFO
    );

    public static List<String> getSampleNames() {
        List<String> ret = new ArrayList<>();

        for (SampleInfo info : ALL) {
            ret.add(info.getName());
        }

        Collections.sort(ret);
        return ret;
    }

    public static SampleInfo find(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name argument is required.");
        }

        SampleInfo ret = null;

        for (SampleInfo info : ALL) {
            // IMPORTANT!
            // == operator compares references not string content
            // equals method compares objects for equality in case of strings that is content
            if (info.getName().equals(name)) {
                ret = info;
                break;
            }
        }

        if (ret == null) {
            throw new IllegalArgumentException("Could not find sample with name= " + name);
        }

        return ret;
    }

    private SampleInfos() {
    }
}
