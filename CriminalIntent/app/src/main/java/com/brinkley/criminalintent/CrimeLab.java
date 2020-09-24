package com.brinkley.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import database.CrimeBaseHelper;
import database.CrimeCursorWrapper;
import database.CrimeDbSchema;
/*
public class CrimeLab {

    private static CrimeLab sCrimeLab; // s prefix!!!!!!

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context) { //other classes won't be able to create CrimeLab object avoiding get
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }

        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>(); //fill in the list default state
        //filling list with a random data
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); //for every second
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) { //searching for all crime info according to the id
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }

        return null;
    }
}
*/

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;


    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context); //if no list in this context => create it
        }

        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();

    }

    public void addCrime(Crime c) {
        ContentValues values = getContentValues(c); //extracting data from crime object to send it to db later

        mDatabase.insert(CrimeDbSchema.CrimeTable.NAME, null, values); //adding new info to db
    } 

    public List<Crime> getCrimes() {
        List<Crime> crimes = new ArrayList<>();

        CrimeCursorWrapper cursor = queryCrimes(null, null); //getting way to db

        try { //
            cursor.moveToFirst(); // starting to run through the table list
            while (!cursor.isAfterLast()) {
                crimes.add(cursor.getCrime()); //filling the list with objects
                cursor.moveToNext(); //"increment"
            }
        } finally {
            cursor.close(); //closing the flow
        }

        return crimes;
    }

    public Crime getCrime(UUID id) {
        CrimeCursorWrapper cursor = queryCrimes(
                CrimeDbSchema.Cols.UUID + " = ?",
                new String[] { id.toString() } //whereArgs for query
        );

        try {
            if(cursor.getCount() == 0) { //check for emptiness
                return null;
            }

            cursor.moveToFirst();
            return cursor.getCrime();
        } finally {
            cursor.close();
        }
    }

    private CrimeCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CrimeDbSchema.CrimeTable.NAME,
                null, //selecting all columns
                whereClause,
                whereArgs,
                null, //groupBy
                null, //having
                null //orderBy
        );

        return new CrimeCursorWrapper(cursor);
    }

    public void updateCrime(Crime crime) {
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);

        mDatabase.update(CrimeDbSchema.CrimeTable.NAME, values, //name and object
                CrimeDbSchema.Cols.UUID + " = ?", //sending id == WHERE
                new String[]{ uuidString }); //sending with ? (not with WHERE) because the string can contain sql code
    }

    private static ContentValues getContentValues(Crime crime) { //creating ContentValues object to store data of the crime
        ContentValues values = new ContentValues();
        //name of the column is the key
        values.put(CrimeDbSchema.Cols.UUID, crime.getId().toString());
        values.put(CrimeDbSchema.Cols.TITLE, crime.getTitle());
        values.put(CrimeDbSchema.Cols.DATE, crime.getDate().getTime());
        values.put(CrimeDbSchema.Cols.SOLVED, crime.isSolved() ? 1 : 0);

        return values;
    }
}

