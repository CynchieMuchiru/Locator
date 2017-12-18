package ke.co.locator.hostel.startup;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import ke.co.locator.hostel.cache.ImagePipelineConfigFactory;

/**
 * Created by muath on 12/16/2017.
 */
public class FrescoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
    }

}
