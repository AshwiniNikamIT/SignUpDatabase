package com.example.signupdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;


    public class database extends SQLiteOpenHelper {
        public static final String databaseName = "userInfo";
        public static final String tableName = "UserData";
        public static final String col_1 = "ID";
        public static final String col_2 = " NAME";
        public static final String cal_3 = "SURNAME";
        public static final String cal_4 = "EMAIL";
        public static final String cal_5 = "PASSWORD";
        static int version = 1;


        public database(Context context) {
            super(context, databaseName, null, version);

        }



        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + tableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,EMAIL TEXT,PASSWORD TEXT)");
        }



        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + tableName);
            onCreate(db);
        }



        public boolean insertData(String name, String surname, String email, String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(col_2, name);
            contentValues.put(cal_3, surname);
            contentValues.put(cal_4, email);
            contentValues.put(cal_5, password);
            long result = db.insert(tableName, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }



        public  boolean isLogin(String mail,String pass)
        {
            SQLiteDatabase db=this.getReadableDatabase();
            String sql=  "Select * from'"+tableName+"'where EMAIL='"+mail+"'and PASSWORD='"+pass+"'";
            Cursor c=db.rawQuery(sql,null) ;
            if(c.getCount()>0)

                return false;
            else
                return true;
        }


        public boolean checkMail(String EMAIL) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("Select * from "+tableName+" where EMAIL=?", new String[]{EMAIL});
            if (cursor.getCount() > 0)
                return false;
            else
                return true;

        }

}

