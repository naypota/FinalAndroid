package com.example.user.finalandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "Money";
    private static final int DATABASE_VERSION = 120;
    public static final String TABLE_NAME_Moneyy= "Moneyy";
    public static final String COL_ID = "id";
    public static final String COL_TYPE = "type";
    public static final String COL_Money = "money";
    public static final String COL_PICTURE = "picture";
    private static final String CREATE_TABLE_Moneyy = "CREATE TABLE " + TABLE_NAME_Moneyy + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_PICTURE + " TEXT, "
            + COL_Money + " INTEGER, "
            + COL_TYPE + " TEXT)    ";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_Moneyy);
        insertInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_Moneyy);
        onCreate(db);
    }
    private void insertInitialData(SQLiteDatabase db) {

        ContentValues cv = new ContentValues();
        cv.put(COL_PICTURE, "ic_income.png");
        cv.put(COL_TYPE, "คุณพ่อให้เงิน");
        cv.put(COL_Money, 8000);
        db.insert(TABLE_NAME_Moneyy, null, cv);
        cv = new ContentValues();
        cv.put(COL_PICTURE, "ic_expense.png");
        cv.put(COL_TYPE, "จ่ายค่าหอ");
        cv.put(COL_Money, 2500);
        db.insert(TABLE_NAME_Moneyy, null, cv);
        cv = new ContentValues();
        cv.put(COL_PICTURE, "ic_expense.png");
        cv.put(COL_TYPE, "ซื้อล็อตเตอรี่ 1 ชุด");
        cv.put(COL_Money, 700);
        db.insert(TABLE_NAME_Moneyy, null, cv);
        cv = new ContentValues();
        cv.put(COL_PICTURE, "ic_income.png");
        cv.put(COL_TYPE, "ถูกล็อตเตอรี่รางวัลที่ 1");
        cv.put(COL_Money, 30000000);
        db.insert(TABLE_NAME_Moneyy, null, cv);
}

}
