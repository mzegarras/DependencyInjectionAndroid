package net.msonic.databaseinject;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import net.msonic.databaseinject.service.DatabaseHelper;
import net.msonic.databaseinject.service.IValidateApi;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    @Inject IValidateApi networkApi;
    @Inject SharedPreferences sharedPreferences;
    @Inject DatabaseHelper databaseHelper;

    @Bind(R.id.button) Button button;

    @Bind(R.id.textView)
    TextView textView;

    @BindString(R.string.msg_clientes) String msg_clientes;


    public MainActivityFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //InjectHelper.getDiComponent().inject(this);
        ((CustomApplication) getActivity().getApplication()).getDiComponent().inject(this);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //((CustomApplication) getActivity().getApplication()).getDiComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MainActivityFragment.class.getCanonicalName(),"Injectado");

               Cursor cursor = databaseHelper.getWritableDatabase().rawQuery("SELECT COUNT(*) FROM CLIENTES",new String[]{});

                if(cursor.moveToNext()){
                    textView.setText(String.format(msg_clientes,cursor.getInt(0)));
                }

                cursor.close();

            }
        });

        return view;

    }
}
