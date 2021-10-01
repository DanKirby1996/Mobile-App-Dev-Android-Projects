//Danny Kirby
//109826879
//06/08/2020
//CSE390 Homework 1 Part 3
//Some code borrowed from lecture slides/textbook

package com.example.shoppinglist;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, myDialog.myDialogListener {
    private RecyclerView rv;
    private SQLiteDatabase mydb;
    private RVAdapter rva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ShoppingListDBHelper dbHelper = new ShoppingListDBHelper(this);
        mydb = dbHelper.getWritableDatabase();

        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rva = new RVAdapter(this, getAllItems());
        rv.setAdapter(rva);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                removeByID((long)viewHolder.itemView.getTag());
            }
        }).attachToRecyclerView(rv);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }




    //SETTINGS
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    //ALERTDIALOG
    public void openDialog(){
        myDialog mydialog = new myDialog();
        mydialog.show(getSupportFragmentManager(), "Shopping List");
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

//WHAT TO DO WHEN SAVE IS HIT
    @Override
    public void applyTexts(String name, String desc, String price, Boolean purchased, String categ) {

        ContentValues cv = new ContentValues();
        cv.put(ShoppingListData.ListEntry.COLUMN_NAME, name);
        cv.put(ShoppingListData.ListEntry.COLUMN_CATEGORY, categ);
        cv.put(ShoppingListData.ListEntry.COLUMN_DESC, desc);
        cv.put(ShoppingListData.ListEntry.COLUMN_PRICE, price);
        cv.put(ShoppingListData.ListEntry.COLUMN_PURCHASED, purchased);

        mydb.insert(ShoppingListData.ListEntry.TABLE_NAME, null, cv);
        rva.swapCursor(getAllItems());
    }

    private Cursor getAllItems() {
        return mydb.query(ShoppingListData.ListEntry.TABLE_NAME, null, null, null, null, null, ShoppingListData.ListEntry.COLUMN_NAME);
    }

    public void removeByID(long id){
        mydb.delete(ShoppingListData.ListEntry.TABLE_NAME, ShoppingListData.ListEntry._ID + "=" + id,null);
        rva.swapCursor(getAllItems());
    }
}