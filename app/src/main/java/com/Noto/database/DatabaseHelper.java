package com.Noto.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.Noto.model.Note;
import com.Noto.NoteInterface;

public class DatabaseHelper extends SQLiteOpenHelper implements NoteInterface { //10120175 - I Wayan Widi P - IF5 - May 2023

    public DatabaseHelper(@Nullable Context context) {
        super(context, "db_note", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE t_note (id TEXT, title TEXT, category TEXT, description TEXT, date TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE t_note");
    }

    public Cursor read(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM t_note", null);
    }

    public boolean create (Note note){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("INSERT INTO t_note VALUES ('"+note.getId()+"','"+note.getTitle()+"','"+note.getCategory()+"','"+note.getDesc()+"','"+note.getDate()+"')");
        return true;
    }

    public boolean update (Note note){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE t_note SET title='"+note.getTitle()+"', category='"+note.getCategory()+"', description='"+note.getDesc()+"', date='"+note.getDate()+"' WHERE id='"+note.getId()+"'");
        return true;
    }

    public boolean delete(String id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM t_note WHERE id='"+id+"'");
        return true;
    }
}

