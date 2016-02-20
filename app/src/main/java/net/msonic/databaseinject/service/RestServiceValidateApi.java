package net.msonic.databaseinject.service;

import android.util.Log;

/**
 * Created by manuelzegarra on 19/02/16.
 */
public class RestServiceValidateApi implements IValidateApi {

    public RestServiceValidateApi() {
    }



    public boolean validateUser(String username, String password) {
        //Invocamos al web service(imaginemos)
        Log.d(RestServiceValidateApi.class.getCanonicalName(),"validateUser_2222");
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}