package com.android.studentdiary;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MYdatabase extends SQLiteOpenHelper {
    private final Context context;
    private static final String DATABASE_NAME = "Student_data.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "book_name";
    private static final String COLUMN_AUTHOR = "book_author";
    private static final String COLUMN_PAGES = "book_pages";

    // private static final String factory=null;
    public MYdatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " + COLUMN_AUTHOR + " TEXT, " + COLUMN_PAGES + " INTEGER);";
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addBook(String title, String author, int pages) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, title);
        contentValues.put(COLUMN_AUTHOR, author);
        contentValues.put(COLUMN_PAGES, pages);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();

        }
    }

    Cursor readAllData()
    {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        if(db!=null)
        {
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }
    void updateData(String row_id,String title,String author,String pages)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,title);
        cv.put(COLUMN_AUTHOR,author);
        cv.put(COLUMN_PAGES,pages);
        long result=db.update(TABLE_NAME,cv,"id=?",new String[] {row_id});
        if(result==-1)
        {
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Successfully Added", Toast.LENGTH_SHORT).show();
        }
    }
     void deleteOneRow(String row_id)
     {
         SQLiteDatabase db=this.getWritableDatabase();
         long result=db.delete(TABLE_NAME,"id=?",new String[]{row_id});
         if(result==-1)
         {
             Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
         }

         else
         {
             Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
         }
     }


}
