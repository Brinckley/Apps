package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CrimeBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    } //sending basic information to the parent class, to create/open db
    //if db isn't opened => onCreate called. If not => checking version info and upgrading db

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create TABLE " + CrimeDbSchema.CrimeTable.NAME //sql function for creating db with a name
                + "(" + "_id integer primary key autoincrement, " +  //types for db columns
                //names of the columns from the class....
                CrimeDbSchema.Cols.UUID + ", " +
                CrimeDbSchema.Cols.TITLE + ", " +
                CrimeDbSchema.Cols.DATE + ", " +
                CrimeDbSchema.Cols.SOLVED + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
