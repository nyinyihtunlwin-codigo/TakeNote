package projects.nyinyihtunlwin.takenote.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import projects.nyinyihtunlwin.takenote.R;
import projects.nyinyihtunlwin.takenote.adapters.NoteListAdapter;
import projects.nyinyihtunlwin.takenote.database.DBHelperAdapter;
import projects.nyinyihtunlwin.takenote.models.NoteModel;

public class NoteListActivity extends AppCompatActivity {

    @BindView(R.id.rv_note_list)
    RecyclerView rvNoteList;

    private DBHelperAdapter dbHelperAdapter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NoteListActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        dbHelperAdapter = new DBHelperAdapter(this);
        dbHelperAdapter.dbOpen();
        ArrayList<NoteModel> noteModels = dbHelperAdapter.dataQuery();
        dbHelperAdapter.dbClose();
        NoteListAdapter adapter = new NoteListAdapter(getApplicationContext(), noteModels);
        rvNoteList.setAdapter(adapter);
        rvNoteList.setHasFixedSize(true);
        rvNoteList.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = TakeNoteActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
