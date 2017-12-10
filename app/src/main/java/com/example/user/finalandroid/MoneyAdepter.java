package com.example.user.finalandroid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MoneyAdepter extends ArrayAdapter<Money>{
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<Money> mMoneyList;



    public MoneyAdepter(Context mContext, int mLayoutResId, ArrayList<Money> mMoneyList) {
        super(mContext,mLayoutResId,mMoneyList);
        this.mContext = mContext;
        this.mLayoutResId = mLayoutResId;
        this.mMoneyList = mMoneyList;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        Money item = mMoneyList.get(position);
        ImageView image = (ImageView)itemLayout.findViewById(R.id.Type_imageView);
        TextView TypeName = (TextView) itemLayout.findViewById(R.id.Type_EditText);
        TextView Money = (TextView) itemLayout.findViewById(R.id.Money_EditText);
        image.setImageDrawable(Drawable.createFromPath(item.picture));
        TypeName.setText(item.type);
        Money.setText(String.valueOf(item.money));
        if(position == 0){
            TypeName.setTextColor(Color.parseColor("#FFC125"));
            Money.setTextColor(Color.parseColor("#FFC125"));
            TypeName.setTypeface(Typeface.DEFAULT_BOLD);
            Money.setTypeface(Typeface.DEFAULT_BOLD);
            TypeName.setTextSize(20);
            Money.setTextSize(20);
        }


        return itemLayout;
    }
}
