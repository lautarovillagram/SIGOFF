package com.developer.sigoff1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    Button load, find;
    EditText domain, id;

    TextView txtDom, TxtId;

    public static final String SHARED_PREFS = "shared_prefs";
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button load = findViewById(R.id.btnMainLoad);
        EditText id =findViewById(R.id.fldMainId);
        EditText domain = findViewById(R.id.fldMainDomain);
        Button find = findViewById(R.id.btnMainGetDom);
        EditText getDom = findViewById(R.id.fldMainGetDom);
        TextView txtDom = findViewById(R.id.txtMainViewDom);
        TextView txtId = findViewById(R.id.txtMainViewId);

        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor = sp.edit();
        Gson gson = new Gson();


        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this, "prueba", Toast.LENGTH_SHORT).show();
                String dom = domain.getText().toString();
                Checked checked = new Checked(dom, id.getText().toString());
                String json = gson.toJson(checked);
                spEditor.putString(dom, json);
                spEditor.commit();
                domain.setText("");
                id.setText("");
                Toast.makeText(getApplication().getBaseContext(), "cargado", Toast.LENGTH_SHORT).show();

            }   

        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String json = sp.getString(find.getText().toString(), "");
                Checked ch = gson.fromJson(json, Checked.class);





            }
        });





    }
}