package com.example.carlos.tdam_ejercicio223_josecarlosguerrarobles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by carlos on 27/02/18.
 */

public class HelperSQLiteDB extends SQLiteOpenHelper {
    public HelperSQLiteDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE persona (nombre TEXT, no_control TEXT, carrera TEXT)";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists persona");
    }
}
