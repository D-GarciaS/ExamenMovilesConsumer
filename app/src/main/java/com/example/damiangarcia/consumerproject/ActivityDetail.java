package com.example.damiangarcia.consumerproject;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityDetail extends AppCompatActivity {

    EditText nombre;
    EditText categoria;
    EditText tienda;
    EditText telefono;
    EditText ciudad;

    private static final String AUTHORITY =  "com.example.damiangarcia.tareasettings.Provider";
    private static final String PROVIDER_NAME=  AUTHORITY + ".ProductsProvider";

    String [] PROJECTION = { "" };
    String selection;
    String [] selectArgs = {};

//  1) Cosa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nombre = (EditText) findViewById(R.id.activity_detail_Nombre);
        categoria = (EditText) findViewById(R.id.activity_detail_categoria);
        tienda = (EditText) findViewById(R.id.activity_detail_tienda);
        telefono = (EditText) findViewById(R.id.activity_detail_telefono);
        ciudad = (EditText) findViewById(R.id.activity_detail_ciudad);

        String id_producto = getIntent().getExtras().getString("ID_PROD");
        Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/productos/"+id_producto);


        Cursor c = getContentResolver().query(CONTENT_URI,PROJECTION,selection,selectArgs,null);

        if(c.moveToFirst()){
            nombre.setText(c.getString(3));
            categoria.setText(c.getString(5));
            tienda.setText(c.getString(8));
            telefono.setText(c.getString(10));
            ciudad.setText(c.getString(9));
        }

        c.close();
    }
}
