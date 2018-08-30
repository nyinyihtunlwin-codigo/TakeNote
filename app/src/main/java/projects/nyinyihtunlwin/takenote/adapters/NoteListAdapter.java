package projects.nyinyihtunlwin.takenote.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import projects.nyinyihtunlwin.takenote.R;
import projects.nyinyihtunlwin.takenote.activities.NoteListActivity;
import projects.nyinyihtunlwin.takenote.delegates.NoteListDeligate;
import projects.nyinyihtunlwin.takenote.models.NoteModel;
import projects.nyinyihtunlwin.takenote.viewholders.NoteListViewHolder;

/**
 * Created by Dell on 11/23/2017.
 */

public class NoteListAdapter extends RecyclerView.Adapter<NoteListViewHolder> {

    private List<NoteModel> dataList;
    private LayoutInflater inflater;
    private Context context;
    private NoteListDeligate mNoteListDeligate;

    public NoteListAdapter(Context context, List<NoteModel> dataList, NoteListDeligate noteListDeligate) {
        this.dataList = dataList;
        this.context = context;
        this.mNoteListDeligate=noteListDeligate;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public NoteListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_item_note, parent, false);
        return new NoteListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteListViewHolder holder, final int position) {
        holder.tvNote.setText(dataList.get(position).getContent());
        holder.tvTitle.setText(dataList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNoteListDeligate.onTapNote(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setData(List<NoteModel> noteList) {
        this.dataList = noteList;
        notifyDataSetChanged();
    }
}
