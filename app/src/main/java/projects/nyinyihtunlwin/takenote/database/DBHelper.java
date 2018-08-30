package projects.nyinyihtunlwin.takenote.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 11/23/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_Name = "TakeNote";
    public static final String TB_Name = "Note";

    public static final String Note_Content = "Content";
    public static final String Note_Title = "Title";
    public static final String Note_ID = "_id";

    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TB_Name + " (" + Note_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + Note_Title
                + " VARCHAR(225)," + Note_Content + " VARCHAR(225))");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_Name);
        onCreate(db);
    }
}
