package com.example.damiangarcia.consumerproject;

import android.Manifest;
import android.app.LoaderManager;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

public class ActivityMain extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ListView listView;

    private static final String AUTHORITY =  "com.example.damiangarcia.tareasettings.Provider";
    private static final String PROVIDER_NAME=  AUTHORITY + ".ProductsProvider";

    private static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/productos");


    String SELECTION = "";
    String searchString = "";

    private String selectArgs[] = {searchString};

    String [] FROM_COLUMNS = {
            "name", "image"
    };
    int[] TO_IDS = {
            R.id.product_item_name,
            R.id.product_item_category
    };

    MyAdapter mCursorAdapter;

    String[] PROJECTION_COLIMNS = new String[]{
            ""
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find views de la actividad
        listView = (ListView) findViewById(android.R.id.list);


        mCursorAdapter = new MyAdapter(this, R.layout.product_list_item, null,FROM_COLUMNS,TO_IDS,0);

        listView.setAdapter(mCursorAdapter);
        getLoaderManager().restartLoader(0, null, this);
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }


    @Override
    public android.content.Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        selectArgs[0] = searchString;
        return new android.content.CursorLoader(
                this,
                CONTENT_URI,
                PROJECTION_COLIMNS,
                SELECTION,
                selectArgs,
                null);
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor cursor) {
        mCursorAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        mCursorAdapter.swapCursor(null);

    }

}
