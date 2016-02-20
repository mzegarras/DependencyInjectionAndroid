package net.msonic.databaseinject.service;

import android.util.Log;

/**
 * Created by manuelzegarra on 19/02/16.
 */
public class DbServiceValidateApi implements IValidateApi {

    public DbServiceValidateApi() {
    }



    @Override
    public boolean validateUser(String username, String password ) {
        //Invocamos a la bd local(imaginemos)
        Log.d(DbServiceValidateApi.class.getCanonicalName(),"validateUser_1111");

        if (username == null || username.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
