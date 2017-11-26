package projects.nyinyihtunlwin.takenote.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import projects.nyinyihtunlwin.takenote.R;
import projects.nyinyihtunlwin.takenote.database.DBHelperAdapter;

public class TakeNoteActivity extends AppCompatActivity {

    private DBHelperAdapter dbHelperAdapter;
    private EditText etContent;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, TakeNoteActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_note);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelperAdapter = new DBHelperAdapter(getApplicationContext());
        etContent = findViewById(R.id.et_note_content);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveToDB();
    }

    private void saveToDB() {
        dbHelperAdapter.dbOpen();
        if (!etContent.getText().toString().equals("") || etContent.getText().toString().equals(null)) {
            dbHelperAdapter.dataInsert(etContent.getText().toString());
        }
        dbHelperAdapter.dbClose();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_take_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save_note) {
            saveToDB();
            Intent intent = NoteListActivity.newIntent(getApplicationContext());
            startActivity(intent);
        } else if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
