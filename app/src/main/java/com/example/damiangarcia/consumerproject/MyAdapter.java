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

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);

        //find views
        TextView nombre = (TextView) view.findViewById(R.id.product_item_name);
        TextView categoria = (TextView) view.findViewById(R.id.product_item_category);

        //modify views
        nombre.setText(cursor.getString(3));
        categoria.setText(cursor.getString(5));

        nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "asdasd",Toast.LENGTH_SHORT).show();
            }
        });

        //add click listener to spawn next activity
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return super.newView(context, cursor, parent);
    }
}
