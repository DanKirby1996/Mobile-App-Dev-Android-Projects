package com.example.shoppinglist;

import android.provider.BaseColumns;

public class ShoppingListData {

    private ShoppingListData(){}

    public static final class ListEntry implements BaseColumns{
        public static final String TABLE_NAME = "shoppinglist";
        public static final String COLUMN_NAME = "itemname";
        public static final String COLUMN_DESC = "itemdesc";
        public static final String COLUMN_CATEGORY = "itemcategory";
        public static final String COLUMN_PRICE = "itemprice";
        public static final String COLUMN_PURCHASED = "itempurchased";
    }
}
