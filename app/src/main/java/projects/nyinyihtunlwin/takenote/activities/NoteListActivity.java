package projects.nyinyihtunlwin.takenote.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

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
    private NoteListAdapter mNoteListAdapter;

    private List<NoteModel> noteList;

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
        noteList = new ArrayList<>();
        getNotesFromDB();
        mNoteListAdapter = new NoteListAdapter(getApplicationContext(), noteList);
        rvNoteList.setAdapter(mNoteListAdapter);
        rvNoteList.setHasFixedSize(true);
        rvNoteList.setLayoutManager(new GridLayoutManager(this, 2));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = TakeNoteActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    private void getNotesFromDB() {
        dbHelperAdapter.dbOpen();
        noteList = dbHelperAdapter.dataQuery();
        dbHelperAdapter.dbClose();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getNotesFromDB();
        mNoteListAdapter.setData(noteList);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
