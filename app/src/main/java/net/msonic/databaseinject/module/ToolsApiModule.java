package net.msonic.databaseinject.module;

/**
 * Created by manuelzegarra on 19/02/16.
 */

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import net.msonic.databaseinject.CustomApplication;
import net.msonic.databaseinject.service.DatabaseHelper;
import net.msonic.databaseinject.service.IValidateApi;
import net.msonic.databaseinject.service.RestServiceValidateApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ToolsApiModule {


    @Provides
    @Singleton
    public IValidateApi getNetwork(){
        return new RestServiceValidateApi();
    }

    @Provides
    @Singleton
        // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(CustomApplication application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
        // Application reference must come from AppModule.class
    DatabaseHelper providesDatabase(CustomApplication application) {
        DatabaseHelper databaseHelper = new DatabaseHelper(application);
        return databaseHelper;
    }

}