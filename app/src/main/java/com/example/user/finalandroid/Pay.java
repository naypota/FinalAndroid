package com.example.user.finalandroid;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.name;
import static com.example.user.finalandroid.DBHelper.COL_Money;
import static com.example.user.finalandroid.DBHelper.COL_PICTURE;
import static com.example.user.finalandroid.DBHelper.COL_TYPE;

public class Pay extends AppCompatActivity {
    private Button accept;
    private String checkType;
    private String checkMoney;
    private DBHelper mHelper;
    private SQLiteDatabase mDb;
    private String picture = "ic_expense.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        mHelper = new DBHelper(this);
        mDb = mHelper.getReadableDatabase();
        Intent intent = getIntent();
        final EditText editTextType =(EditText)findViewById(R.id.Type_EditText);
        final EditText editTextMoney = (EditText)findViewById(R.id.Money_EditText);
        accept = (Button)findViewById(R.id.accpetpay_button);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkType = String.valueOf(editTextType.getText().toString());
                checkMoney = String.valueOf(editTextMoney.getText().toString());
                if (checkType.length() == 0) {
                    editTextType.setError("ป้อนรายละเอียด");
                }
                if(checkMoney.length() == 0){
                    editTextMoney.setError("กรุณาใส่จำนวนเงิน");
                }else{
                    ContentValues cv = new ContentValues();
                    cv.put(COL_PICTURE, picture);
                    cv.put(COL_TYPE,checkType);
                    cv.put(COL_Money,checkMoney);
                    mDb.insert(DBHelper.TABLE_NAME_Moneyy,null,cv);
                }
                Intent intent = new Intent(Pay.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
