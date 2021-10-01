package com.example.shoppinglist;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVHolder>{
    private Cursor myCursor;
    private Context context;


    public RVAdapter(Context c, Cursor cursor){
        context = c;
        myCursor = cursor;
    }

    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater1 = LayoutInflater.from(context);
        View view = inflater1.inflate(R.layout.list_entry, parent, false);
        return new RVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        if (!myCursor.moveToPosition(position)){
            return;
        }

        String category = myCursor.getString(myCursor.getColumnIndex(ShoppingListData.ListEntry.COLUMN_CATEGORY));
        String name = myCursor.getString(myCursor.getColumnIndex(ShoppingListData.ListEntry.COLUMN_NAME));
        int price = myCursor.getInt(myCursor.getColumnIndex(ShoppingListData.ListEntry.COLUMN_PRICE));
        String desc = myCursor.getString(myCursor.getColumnIndex(ShoppingListData.ListEntry.COLUMN_DESC));
        int purchased = myCursor.getInt(myCursor.getColumnIndex(ShoppingListData.ListEntry.COLUMN_PURCHASED));

        long id = myCursor.getLong(myCursor.getColumnIndex(ShoppingListData.ListEntry._ID));
        holder.itemView.setTag(id);

        holder.itemNameTV.setText(name);
        holder.categoryTextView.setText(category);
        holder.itemDescTextView.setText(desc);
        holder.itemPriceTV.setText("$" + price);



        if (category.matches("Food")){
            holder.categoryImageView.setImageResource(R.drawable.food);
        }
        else if (category.matches("Electronics")){
            holder.categoryImageView.setImageResource(R.drawable.electronics);
        }
        else if (category.matches("Books")){
            holder.categoryImageView.setImageResource(R.drawable.book);
        }
        else if (category.matches("Cleaning Supplies")){
            holder.categoryImageView.setImageResource(R.drawable.cleaning);
        }
        else{
            holder.categoryImageView.setImageResource(R.drawable.pet);
        }


        if (purchased > 0){
            holder.purchasedCB.setChecked(true);
        }
        else{
            holder.purchasedCB.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return myCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if (myCursor != null){
            myCursor.close();
        }
        myCursor = newCursor;
        if (newCursor != null){
            notifyDataSetChanged();
        }
    }

    public class RVHolder extends RecyclerView.ViewHolder{
        TextView categoryTextView;
        TextView itemDescTextView;
        TextView itemNameTV;
        TextView itemPriceTV;
        CheckBox purchasedCB;
        ImageView categoryImageView;


        public RVHolder(@NonNull View view1){
            super(view1);
            categoryTextView = view1.findViewById(R.id.catTextView);
            itemDescTextView = view1.findViewById(R.id.itemDescTV);
            itemNameTV = view1.findViewById(R.id.itemNameTextView);
            itemPriceTV = view1.findViewById(R.id.itemPriceTextView);
            purchasedCB = view1.findViewById(R.id.purchasedCheckBox);
            categoryImageView = view1.findViewById(R.id.catImageView);
        }
    }
}
