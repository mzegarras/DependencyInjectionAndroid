package net.msonic.databaseinject.module;

import net.msonic.databaseinject.CustomApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by manuelzegarra on 19/02/16.
 */
@Module
public class ApplicationModule {

    public CustomApplication mApplication;

    public ApplicationModule(CustomApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    CustomApplication providesApplication() {
        return mApplication;
    }
}