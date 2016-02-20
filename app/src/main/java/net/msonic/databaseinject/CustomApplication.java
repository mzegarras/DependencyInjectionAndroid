package net.msonic.databaseinject;

import android.app.Application;

import net.msonic.databaseinject.component.DaggerToolsComponent;
import net.msonic.databaseinject.component.ToolsComponent;
import net.msonic.databaseinject.module.ApplicationModule;

/**
 * Created by manuelzegarra on 19/02/16.
 */
public class CustomApplication extends Application {


    private ToolsComponent diComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        diComponent = DaggerToolsComponent.builder().applicationModule(new ApplicationModule(this)).build();

    }

    public ToolsComponent getDiComponent(){
        return diComponent;
    }
}
