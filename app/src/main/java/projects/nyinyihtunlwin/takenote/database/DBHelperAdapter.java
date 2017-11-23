package projects.nyinyihtunlwin.takenote.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    public long dataInsert(String fName, String lName, String nrc, String pass, String phno, String address, String city, int gender) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.fName, fName);
        cv.put(DBHelper.lName, lName);
        cv.put(DBHelper.Nrc, nrc);
        cv.put(DBHelper.Gender, gender);
        cv.put(DBHelper.Pass, pass);
        cv.put(DBHelper.Address, address);
        cv.put(DBHelper.City, city);
        cv.put(DBHelper.Phno, phno);
        long id = db.insert(DBHelper.TB_Name, null, cv);
        return id;
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

    public ArrayList<Student> dataUpload() {
        String[] columns = {MyHelper.fName, MyHelper.lName, MyHelper.Nrc, MyHelper.Gender, MyHelper.Pass, MyHelper.Address, MyHelper.City, MyHelper.Phno};
        Cursor c = db.query(MyHelper.TB_Name, columns, null, null, null, null, null);
        ArrayList<Student> stdList = new ArrayList<Student>();

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            int fNameIndex = c.getColumnIndex(MyHelper.fName);
            int lNameIndex = c.getColumnIndex(MyHelper.lName);
            int nrcIndex = c.getColumnIndex(MyHelper.Nrc);
            int genderIndex = c.getColumnIndex(MyHelper.Gender);
            int passIndex = c.getColumnIndex(MyHelper.Pass);
            int addressIndex = c.getColumnIndex(MyHelper.Address);
            int cityIndex = c.getColumnIndex(MyHelper.City);
            int phnoIndex = c.getColumnIndex(MyHelper.Phno);

            Student student = new Student();
            student.setfName(c.getString(fNameIndex));
            student.setlName(c.getString(lNameIndex));
            student.setNrc(c.getString(nrcIndex));
            student.setGender(c.getInt(genderIndex));
            student.setPass(c.getString(passIndex));
            student.setAddress(c.getString(addressIndex));
            student.setCity(c.getString(cityIndex));
            student.setPhno(c.getString(phnoIndex));
            stdList.add(student);
        }
        return stdList;
    }*/
}
