package net.msonic.databaseinject.component;

/**
 * Created by manuelzegarra on 19/02/16.
 */

import net.msonic.databaseinject.MainActivity;
import net.msonic.databaseinject.MainActivityFragment;
import net.msonic.databaseinject.module.ApplicationModule;
import net.msonic.databaseinject.module.ToolsApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,ToolsApiModule.class})
public interface ToolsComponent {
    // to update the fields in your activities
    void inject(MainActivity activity);
    void inject(MainActivityFragment activity);
}
