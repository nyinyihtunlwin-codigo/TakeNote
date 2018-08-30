package projects.nyinyihtunlwin.takenote.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import projects.nyinyihtunlwin.takenote.Utils;
import projects.nyinyihtunlwin.takenote.models.NoteModel;

/**
 * Created by Dell on 11/23/2017.
 */

public class DBHelperAdapter {

    private Context context;
    private DBHelper helper;
    private SQLiteDatabase db;

    public DBHelperAdapter(Context context) {
        this.context = context;
    }

    public void dbOpen() {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public void dbClose() {
        db.close();
    }

    public long dataInsert(NoteModel note) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.Note_Title, note.getTitle());
        cv.put(DBHelper.Note_Content, note.getContent());
        long id = db.insert(DBHelper.TB_Name, null, cv);
        Utils.showToast(context, "Saved.");
        return id;
    }

    public ArrayList<NoteModel> dataQuery() {
        ArrayList<NoteModel> noteModels = new ArrayList<>();
        String[] columns = {DBHelper.Note_ID, DBHelper.Note_Content};
        Cursor c = db.query(DBHelper.TB_Name, columns, null, null, null, null, null);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            int idIndex = c.getColumnIndex(DBHelper.Note_ID);
            int titleIndex = c.getColumnIndex(DBHelper.Note_Title);
            int contentIndex = c.getColumnIndex(DBHelper.Note_Content);
            NoteModel noteModel = new NoteModel();
            noteModel.setId(c.getInt(idIndex));
            noteModel.setTitle(c.getString(titleIndex));
            noteModel.setContent(c.getString(contentIndex));
            noteModels.add(noteModel);
        }
        return noteModels;
    }


   /* public Student dataQuery(String userName, String pass) {
        String[] columns = {MyHelper.fName, MyHelper.lName, MyHelper.Nrc, MyHelper.Gender, MyHelper.Pass, MyHelper.Address, MyHelper.City, MyHelper.Phno};
        Cursor c = db.query(MyHelper.TB_Name, columns, MyHelper.fName
                + " = '" + userName + "' AND " + MyHelper.Pass + " = '" + pass + "'", null, null, null, null);
        Student student = new Student();
        if (c.getCount() == 1) {
            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                int fNameIndex = c.getColumnIndex(MyHelper.fName);
                int lNameIndex = c.getColumnIndex(MyHelper.lName);
                int nrcIndex = c.getColumnIndex(MyHelper.Nrc);
                int genderIndex = c.getColumnIndex(MyHelper.Gender);
                int passIndex = c.getColumnIndex(MyHelper.Pass);
                int addressIndex = c.getColumnIndex(MyHelper.Address);
                int cityIndex = c.getColumnIndex(MyHelper.City);
                int phnoIndex = c.getColumnIndex(MyHelper.Phno);


                student.setfName(c.getString(fNameIndex));
                student.setlName(c.getString(lNameIndex));
                student.setNrc(c.getString(nrcIndex));
                student.setGender(c.getInt(genderIndex));
                student.setPass(c.getString(passIndex));
                student.setAddress(c.getString(addressIndex));
                student.setCity(c.getString(cityIndex));
                student.setPhno(c.getString(phnoIndex));
            }
            student.setfName("Success");
        } else {
            student.setfName("No Result");
        }
        return student;
    }
*/
}
