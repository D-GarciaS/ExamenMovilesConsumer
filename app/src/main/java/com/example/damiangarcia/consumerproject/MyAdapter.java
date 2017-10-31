package com.example.damiangarcia.consumerproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Damian Garcia on 10/29/2017.
 */

public class MyAdapter extends SimpleCursorAdapter
{
    private Context mContext;
    private int layout;
    private LayoutInflater inflater;


    public MyAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        mContext = context;
        this.layout = layout;
        inflater = LayoutInflater.from(context);
    }

    /*Lista luisa
    * 1. Cosas buenas (fake)
    * */

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);

        //find views
        TextView nombre = (TextView) view.findViewById(R.id.product_item_name);
        TextView categoria = (TextView) view.findViewById(R.id.product_item_category);
        TextView text_id = (TextView) view.findViewById(R.id.product_list_position);

        //modify views
        nombre.setText(cursor.getString(4));
        categoria.setText(cursor.getString(6));
        final String id_producto = cursor.getString(0);


        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(context, ActivityDetail.class);
                intent.putExtra("ID_PROD", id_producto);
                context.startActivity(intent);
           }
        });

        //add click listener to spawn next activity
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return super.newView(context, cursor, parent);
    }
}
