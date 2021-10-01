package com.example.shoppinglist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class ShoppingListDBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "shoppinglist.db";
    public static final int DATABASE_VERSION = 3;


    public ShoppingListDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            final String SQL_CREATE_SHOPPINGLIST_TABLE =
            "create table shoppinglist (_id integer primary key autoincrement, "
                    + "itemname text not null, itemcategory text, "
                    + "itemdesc text, "
                    + "itemprice text, itempurchased integer);";

            db.execSQL(SQL_CREATE_SHOPPINGLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ShoppingListData.ListEntry.TABLE_NAME);
        onCreate(db);
    }
}
