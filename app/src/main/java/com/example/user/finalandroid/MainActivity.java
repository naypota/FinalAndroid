package com.example.user.finalandroid;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.name;
import static android.os.Build.VERSION_CODES.M;
import static com.example.user.finalandroid.DBHelper.COL_ID;
import static com.example.user.finalandroid.DBHelper.COL_Money;
import static com.example.user.finalandroid.DBHelper.COL_PICTURE;
import static com.example.user.finalandroid.DBHelper.COL_TYPE;

public class MainActivity extends AppCompatActivity {
    private Button money,pay;
    private DBHelper mHelper;
    private SQLiteDatabase mDb;
    private MoneyAdepter mAdapter;
    private ArrayList<Money> mMoneyItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = new DBHelper(this);
        mDb = mHelper.getReadableDatabase();
        money = (Button)findViewById(R.id.Money_button);
        pay = (Button)findViewById(R.id.Pay_Button);
        Cursor cursor = mDb.query(DBHelper.TABLE_NAME_Moneyy,null,null,null,null,null,COL_ID+ " DESC");
        int  i = 1;
        while (cursor.moveToNext()) {
            if(i>10) break;
            int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
            String picture = cursor.getString(cursor.getColumnIndex(COL_PICTURE));
            String Type = cursor.getString(cursor.getColumnIndex(COL_TYPE));
            int Moneyy = cursor.getInt(cursor.getColumnIndex(COL_Money));
            Money item = new Money(id,  i+". "+picture, Type, Moneyy);
            mMoneyItemList.add(item);
            i++;
        }
        mAdapter = new MoneyAdepter(
                this,
                R.layout.activity_item,
                mMoneyItemList
        );
        ListView lv = (ListView) findViewById(R.id.ListMoney);
        lv.setAdapter((ListAdapter) mAdapter);
        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Rayrub.class);
                startActivity(intent);
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Pay.class);
                startActivity(intent);
            }
        });

    }
}
