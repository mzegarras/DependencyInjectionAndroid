package net.msonic.databaseinject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import net.msonic.databaseinject.service.DatabaseHelper;
import net.msonic.databaseinject.service.IValidateApi;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject IValidateApi networkApi;
    @Inject SharedPreferences sharedPreferences;
    @Inject DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //InjectHelper.getDiComponent().inject(this);
        ((CustomApplication) getApplication()).getDiComponent().inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            networkApi.validateUser("admin","124");
            return true;
        }else if(id == R.id.action_db){
            databaseHelper.getWritableDatabase().execSQL("INSERT INTO CLIENTES (NAME) VALUES (?)",new String[]{String.valueOf(System.currentTimeMillis())});
        }


        return super.onOptionsItemSelected(item);
    }
}
