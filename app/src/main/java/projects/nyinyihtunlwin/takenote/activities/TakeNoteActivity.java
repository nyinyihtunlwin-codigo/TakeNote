package projects.nyinyihtunlwin.takenote.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import projects.nyinyihtunlwin.takenote.R;
import projects.nyinyihtunlwin.takenote.database.DBHelperAdapter;
import projects.nyinyihtunlwin.takenote.models.NoteModel;

public class TakeNoteActivity extends AppCompatActivity {

    private DBHelperAdapter dbHelperAdapter;
    private EditText etTitle, etContent;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, TakeNoteActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        dbHelperAdapter = new DBHelperAdapter(getApplicationContext());
        etTitle = findViewById(R.id.et_note_title);
        etContent = findViewById(R.id.et_note_content);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveToDB();
    }

    private void saveToDB() {
        dbHelperAdapter.dbOpen();
        if (!etTitle.getText().toString().equals("") || etTitle.getText().toString().equals(null)) {
            String title = etTitle.getText().toString();
            String content = etContent.getText().toString();
            NoteModel noteModel = new NoteModel();
            noteModel.setTitle(title);
            noteModel.setContent(content);
            dbHelperAdapter.dataInsert(noteModel);
        } else {
            Toast.makeText(getApplicationContext(), "Enter Title", Toast.LENGTH_SHORT).show();
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
