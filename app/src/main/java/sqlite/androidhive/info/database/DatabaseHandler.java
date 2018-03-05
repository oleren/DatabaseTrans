package sqlite.androidhive.info.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by mathi on 02-03-2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_SHOCKS = "shocks";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TIME = "time";
    private static final String KEY_SHOCKSTRENGTH = "ShockStrength";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SHOCKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TIME + " TEXT,"
                + KEY_SHOCKSTRENGTH + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOCKS);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addShoks(Shocks shocks) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TIME, shocks.getTime()); // Contact Name
        values.put(KEY_SHOCKSTRENGTH, shocks.getShock()); // Contact Phone Number

        // Inserting Row
        db.insert(TABLE_SHOCKS, null, values);
        db.close(); // Closing database connection
    }


    // Getting single contact
    public Shocks getShocks(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SHOCKS, new String[]{KEY_ID,
                        KEY_TIME, KEY_SHOCKSTRENGTH}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Shocks shocks = new Shocks(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return shocks;
    }


    // Getting All Contacts
    public List<Shocks> getAllShocks() {
        // Getting All Contacts
        public List<Shocks> getAllShocks() {
            List<Shocks> shocksList = new ArrayList<Shocks>();
            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_SHOCKS;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Shocks shocks = new Shocks();
                    shocks.setId(Integer.parseInt(cursor.getString(0)));

                    shocks.setTime(cursor.get(1));

                    shocks.setShockStrenght(cursor.getLong(2));
                    // Adding contact to list
                    shocksList.add(shocks);
                } while (cursor.moveToNext());
            }

            // return contact list
            return shocksList;
        }

        // Getting contacts Count

    public int getShocksCount() {
        String countQuery = "SELECT  * FROM " + TABLE_SHOCKS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }


    // Updating single contact
    public int updateShocks(Shocks shocks) {

        public int updateShocks(Shocks) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(KEY_TIME, shocks.getTime());
            values.put(KEY_SHOCKSTRENGTH, shocks.getShock());

            // updating row
            return db.update(TABLE_SHOCKS, values, KEY_ID + " = ?",
                    new String[] { String.valueOf(shocks.getId()) });
    }

    // Deleting single contact
    public void deleteShocks(Shocks shocks) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SHOCKS, KEY_ID + " = ?",
                new String[] { String.valueOf(shocks.getId()) });
        db.close();

    }
}