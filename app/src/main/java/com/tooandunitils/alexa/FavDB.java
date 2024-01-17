package com.tooandunitils.alexa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FavDB extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "VoiceCommands.db";

    public static String TABLE_NAME = "Commands";
    public static String COLUMN_TEXT = "text";

    public static final String TABLE_NAME_1 = "CommandsTable";
    public static final String COLUMN_TEXT_1 = "custom_text";

    public FavDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TEXT + " TEXT )");

        db.execSQL("CREATE TABLE " + TABLE_NAME_1 + " (" +
                COLUMN_TEXT_1 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);

        onCreate(db);

    }

    public long insertdata(String category) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEXT, category);
        long rowId = db.insert(TABLE_NAME, null, values);

        return rowId;

    }

    public Cursor readdata() {
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from " + TABLE_NAME + " ORDER BY " + COLUMN_TEXT + " DESC";
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(qry, null);
        }
        return cursor;
    }

    public boolean isFavorite(String itemText) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_TEXT + " = ?", new String[]{itemText});
        boolean isFavorite = cursor.moveToFirst();
        cursor.close();
        return isFavorite;
    }

    public boolean deleteCategory_fav(Context ctx, String text) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            // Check if the record exists
            Cursor cursor = db.rawQuery("SELECT * FROM Commands WHERE text = ?", new String[]{String.valueOf(text)});

            if (cursor.getCount() > 0) {
                // The record exists, proceed with deletion
                long result = db.delete("Commands", "text = ?", new String[]{String.valueOf(text)});
                cursor.close();

                if (result > 0) {
                    return true;  // Deletion was successful
                } else {
                    // Log the result for debugging
                    Log.e("DeleteCategoryFav", "Deletion failed, result code: " + result);
                    return false;  // Deletion failed
                }
            } else {
                // Record does not exist
                cursor.close();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception for debugging
            Log.e("DeleteCategoryFav", "Exception: " + e.getMessage());
            return false;
        }
    }

    public boolean removeData(String text) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            // Check if the record exists
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_TEXT + " = ?", new String[]{text});

            if (cursor.getCount() > 0) {
                // The record exists, proceed with deletion
                long result = db.delete(TABLE_NAME, COLUMN_TEXT + " = ?", new String[]{text});
                cursor.close();

                if (result > 0) {
                    return true;  // Deletion was successful
                } else {
                    // Log the result for debugging
                    Log.e("RemoveData", "Deletion failed, result code: " + result);
                    return false;  // Deletion failed
                }
            } else {
                // Record does not exist
                cursor.close();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception for debugging
            Log.e("RemoveData", "Exception: " + e.getMessage());
            return false;
        }
    }





    public boolean insertData_custom(String text) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TEXT_1, text);
        long result = db.insert(TABLE_NAME_1, null, contentValues);
        return result != -1;
    }

    public Cursor readdata_custom() {
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from " + TABLE_NAME_1 + " ORDER BY " + COLUMN_TEXT_1 + " DESC";
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(qry, null);
        }
        return cursor;
    }

    public boolean deleteCategory_custom(Context ctx, String text) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            // Check if the record exists
            Cursor cursor = db.rawQuery("SELECT * FROM CommandsTable WHERE custom_text = ?", new String[]{String.valueOf(text)});

            if (cursor.getCount() > 0) {
                // The record exists, proceed with deletion
                long result = db.delete("CommandsTable", "custom_text = ?", new String[]{String.valueOf(text)});
                cursor.close();

                if (result > 0) {
                    return true;  // Deletion was successful
                } else {
                    // Log the result for debugging
                    Log.e("DeleteCategoryFav", "Deletion failed, result code: " + result);
                    return false;  // Deletion failed
                }
            } else {
                // Record does not exist
                cursor.close();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log the exception for debugging
            Log.e("DeleteCategoryFav", "Exception: " + e.getMessage());
            return false;
        }
    }

}